package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.AsistenciaRequestDTO;
import com.aprendeya.aprendeyaapi.dto.AsistenciaResponseDTO;
import com.aprendeya.aprendeyaapi.exception.ResourceNotFoundException;
import com.aprendeya.aprendeyaapi.mapper.AsistenciaMapper;
import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Asistencia;
import com.aprendeya.aprendeyaapi.model.entity.Sesion;
import com.aprendeya.aprendeyaapi.repository.AlumnoRepository;
import com.aprendeya.aprendeyaapi.repository.AsistenciaRepository;
import com.aprendeya.aprendeyaapi.repository.SesionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AsistenciaService {

    private final AsistenciaRepository asistenciaRepository;
    private final AlumnoRepository alumnoRepository;
    private final SesionRepository sesionRepository;
    private final AsistenciaMapper asistenciaMapper;

    @Transactional
    public AsistenciaResponseDTO buscarAsistencias(AsistenciaRequestDTO asistenciaRequestDTO) {
        Alumno alumno = alumnoRepository.buscarAlumnoPorID(asistenciaRequestDTO.getIdAlumno());
        Sesion sesion = sesionRepository.findById(asistenciaRequestDTO.getIdSesion());

        if(sesion == null || alumno == null) {
            throw new ResourceNotFoundException("La sesion o el alumno no existe");
        }
        else{
            Asistencia asistencia = asistenciaRepository.findByAlumnoAndSesion(alumno, sesion);
            if(asistencia == null) {
                throw new ResourceNotFoundException("El alumno no esta vinculado a esa sesion");
            }
            else{
                return asistenciaMapper.convertToDTO(asistencia);
            }
        }
    }
}
