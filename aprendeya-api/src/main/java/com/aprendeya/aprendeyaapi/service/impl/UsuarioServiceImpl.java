package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.UsuarioRegistroDTO;
import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Padre;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import com.aprendeya.aprendeyaapi.model.enums.TipoUsuario;
import com.aprendeya.aprendeyaapi.repository.*;
import com.aprendeya.aprendeyaapi.service.UsuarioService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UserRepository usuarioRepository;
    private final StudentRepository studentRepository;
    private final PadreRepository padreRepository;
    private final aTutorRepository aTutorRepository;

    @Transactional
    @Override
    public Usuario registerUser(UsuarioRegistroDTO registroDTO) {
        if (usuarioRepository.existsByEmail(registroDTO.getEmail())) {
            throw new RuntimeException("El email ya está registrado");
        }

        Usuario newUser = new Usuario();
        newUser.setNombre(registroDTO.getNombre());
        newUser.setApellido(registroDTO.getApellido());
        newUser.setEmail(registroDTO.getEmail());
        newUser.setContrasena(registroDTO.getContrasena());
        newUser.setTipoUsuario(TipoUsuario.valueOf(registroDTO.getTipoUsuario()));
        newUser = usuarioRepository.save(newUser);

        switch (newUser.getTipoUsuario()) {
            case ESTUDIANTE:
                Alumno alumno = new Alumno();
                alumno.setUsuario(newUser);
                alumno.setGrado(registroDTO.getGrado());
                alumno.setDescripcion(registroDTO.getDescripcion());
                alumno.setFamiliar(false); // Asumimos que el estudiante no es familiar
                studentRepository.save(alumno);
                break;

            case FAMILIAR:
                Padre padre = new Padre();
                padre.setUsuario(newUser);
                Integer idAlumno = registroDTO.getIdAlumno(); // Obtener el ID del alumno del DTO
                Alumno alumnoExistente = studentRepository.findById(idAlumno)
                        .orElseThrow(() -> new RuntimeException("El ID del alumno no es válido"));
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
                throw new RuntimeException("Tipo de usuario no válido");
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
}
