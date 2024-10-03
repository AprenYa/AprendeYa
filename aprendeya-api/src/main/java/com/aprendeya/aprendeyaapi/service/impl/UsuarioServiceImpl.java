package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.DeleteUserRequestDTO;
import com.aprendeya.aprendeyaapi.dto.UsuarioRegistroDTO;
import com.aprendeya.aprendeyaapi.exception.TipoUsuarioNoValidoException;
import com.aprendeya.aprendeyaapi.exception.UserNotFoundException;
import com.aprendeya.aprendeyaapi.exception.UsuarioYaRegistradoException;
import com.aprendeya.aprendeyaapi.exception.AlumnoNoValidoException;
import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Padre;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import com.aprendeya.aprendeyaapi.model.enums.TipoUsuario;
import com.aprendeya.aprendeyaapi.mapper.UsuarioMapper;
import com.aprendeya.aprendeyaapi.repository.*;
import com.aprendeya.aprendeyaapi.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UserRepository usuarioRepository;
    private final StudentRepository studentRepository;
    private final PadreRepository padreRepository;
    private final aTutorRepository aTutorRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Usuario registerUser(UsuarioRegistroDTO registroDTO) {
        if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
            throw new UsuarioYaRegistradoException();
        }
        try {
            TipoUsuario tipoUsuario = TipoUsuario.valueOf(registroDTO.getTipoUsuario());
        } catch (IllegalArgumentException e) {
            throw new TipoUsuarioNoValidoException();
        }
        // Codifica la contraseña usando el PasswordEncoder inyectado
        String encodedPassword = passwordEncoder.encode(registroDTO.getContrasena());
        registroDTO.setContrasena(encodedPassword);
        // Usar el mapper para convertir el DTO a entidad
        Usuario newUser = usuarioMapper.toEntity(registroDTO);
        newUser = usuarioRepository.save(newUser);

        switch (newUser.getTipoUsuario()) {
            case ESTUDIANTE:
                Alumno alumno = new Alumno();
                alumno.setUsuario(newUser);
                alumno.setGrado(registroDTO.getGrado());
                alumno.setDescripcion(registroDTO.getDescripcion());
                alumno.setFamiliar(false);
                studentRepository.save(alumno);
                break;

            case FAMILIAR:
                Padre padre = new Padre();
                padre.setUsuario(newUser);
                Integer idAlumno = registroDTO.getIdAlumno();
                Alumno alumnoExistente = studentRepository.findById(idAlumno)
                        .orElseThrow(AlumnoNoValidoException::new);
                padre.setAlumno(alumnoExistente);
                padreRepository.save(padre);
                break;

            case DOCENTE:
                Tutor tutor = new Tutor();
                tutor.setUsuario(newUser);
                tutor.setEspecialidad(registroDTO.getEspecialidad());
                tutor.setExperiencia(registroDTO.getExperiencia());
                tutor.setTarifaBase(registroDTO.getTarifaBase());
                aTutorRepository.save(tutor);
                break;

            default:
                throw new TipoUsuarioNoValidoException();
        }

        return newUser;
    }

    @Override
    public Tutor registerTutor(Tutor tutor) {
        // Implementa el registro de tutor si es necesario
        return aTutorRepository.save(tutor);
    }

    @Override
    public Padre registerPadre(Padre padre) {
        // Implementa el registro de padre si es necesario
        return padreRepository.save(padre);
    }

    @Override
    public Alumno registerAlumno(Alumno alumno) {
        // Implementa el registro de alumno si es necesario
        return studentRepository.save(alumno);
    }

    @Override
    @Transactional
    public void deleteUser(DeleteUserRequestDTO deleteUserRequestDTO) {
        Integer userId = deleteUserRequestDTO.getIdUsuario();

        // Verifica si el usuario existe
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Usuario no encontrado con ID: " + userId));

        // Verifica si el tipo de usuario es nulo
        if (usuario.getTipoUsuario() == null) {
            throw new IllegalArgumentException("El tipo de usuario no puede ser nulo");
        }

        // Eliminar las relaciones dependiendo del tipo de usuario
        switch (usuario.getTipoUsuario()) {
            case ESTUDIANTE:
                // Verifica si el usuario es un Alumno
                Alumno alumno = studentRepository.findByUsuario(usuario)
                        .orElseThrow(() -> new UserNotFoundException("El alumno no encontrado para el usuario: " + userId));
                // Primero, elimina el padre relacionado, si existe
                Optional<Padre> padreOptional = padreRepository.findByAlumno(alumno);
                padreOptional.ifPresent(padreRepository::delete);
                studentRepository.delete(alumno);
                break;
            case FAMILIAR:
                padreRepository.deleteByUsuario(usuario);
                break;
            case DOCENTE:
                aTutorRepository.deleteByUsuario(usuario);
                break;
            default:
                throw new IllegalArgumentException("Tipo de usuario no válido");
        }

        // Finalmente, eliminar el usuario
        usuarioRepository.delete(usuario);
    }





}
