package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.AlumnoPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.AlumnoResponseDTO;
import com.aprendeya.aprendeyaapi.exception.ResourceNotFoundException;
import com.aprendeya.aprendeyaapi.mapper.AlumnoMapper;
import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.repository.AlumnoRepository;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final AlumnoMapper alumnoMapper;
    private final EntityManager entityManager;

    @Transactional
    public AlumnoResponseDTO editarPerfil(AlumnoPerfilRequestDTO alumnoPerfilRequestDTO, int idAlumno) {
        Alumno alumno = alumnoRepository.buscarAlumnoPorID(idAlumno);

        if(alumno == null) {
            throw new ResourceNotFoundException("El alumno con el ID "+idAlumno+" no existe.");
        }

        alumnoRepository.actualizarDescripcion(idAlumno, alumnoPerfilRequestDTO.getDescripcion());
        entityManager.refresh(alumno);
        Alumno alumnoActualizado = alumnoRepository.buscarAlumnoPorID(idAlumno);

        return alumnoMapper.convertToDTO(alumnoActualizado);
    }
}
