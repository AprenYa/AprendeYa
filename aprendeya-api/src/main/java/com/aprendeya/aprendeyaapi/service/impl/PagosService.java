package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.PagoRequestDTO;
import com.aprendeya.aprendeyaapi.dto.PagoResponseDTO;
import com.aprendeya.aprendeyaapi.exception.ResourceNotFoundException;
import com.aprendeya.aprendeyaapi.mapper.PagoMapper;
import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Curso;
import com.aprendeya.aprendeyaapi.model.entity.Pago;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.model.enums.EstadoPago;
import com.aprendeya.aprendeyaapi.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class PagosService {

    private final CursoRepository cursoRepository;
    private final AlumnoRepository alumnoRepository;
    private final TutorRepository tutorRepository;
    private final SesionRepository sesionRepository;
    private final PagoRepository pagoRepository;
    private final PagoMapper pagoMapper;

    @Transactional
    public PagoResponseDTO notificarPago(PagoRequestDTO pagoRequestDTO) {
        Curso curso = cursoRepository.buscarCursoPorNombre(pagoRequestDTO.getNombreCurso());
        Alumno alumno = alumnoRepository.buscarAlumnoPorID(pagoRequestDTO.getIdAlumno());
        Tutor tutor = tutorRepository.buscarTutorPorID(pagoRequestDTO.getIdTutor());


        if (curso == null || alumno == null || tutor == null) {
            throw new ResourceNotFoundException("El curso o el alumno no existe");
        }
        else{
            Tutor tutorCurso = sesionRepository.buscarTutor(curso, tutor);
            if(tutorCurso == tutor){
                Pago pago = new Pago();
                pago.setAlumno(alumno);
                pago.setTutor(tutor);
                pago.setMonto(tutor.getTarifaBase());
                pago.setEstado(EstadoPago.PENDIENTE);
                pago.setFechaPago(LocalDate.now());
                pagoRepository.save(pago);

                return pagoMapper.convertToDTO(pago);
            }
            else{
                throw new ResourceNotFoundException("El tutor no dicta ese curso");
            }
        }
    }

}
