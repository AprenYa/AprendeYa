package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.PagoRequestDTO;
import com.aprendeya.aprendeyaapi.dto.PagoResponseDTO;
import com.aprendeya.aprendeyaapi.dto.PaypalResponseDTO;
import com.aprendeya.aprendeyaapi.exception.ResourceNotFoundException;
import com.aprendeya.aprendeyaapi.mapper.PagoMapper;
import com.aprendeya.aprendeyaapi.model.entity.*;
import com.aprendeya.aprendeyaapi.model.enums.EstadoInscripcion;
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
    private final InscripcionRepository inscripcionRepository;

    @Transactional
    public PagoResponseDTO notificarPago(PagoRequestDTO pagoRequestDTO) {
        Curso curso = cursoRepository.buscarCursoPorNombre(pagoRequestDTO.getNombreCurso());
        Alumno alumno = alumnoRepository.buscarAlumnoPorID(pagoRequestDTO.getIdAlumno());
        Tutor tutor = tutorRepository.buscarTutorPorID(pagoRequestDTO.getIdTutor());


        if (curso == null || alumno == null || tutor == null) {
            throw new ResourceNotFoundException("El curso, el alumno o el tutor no existe");
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

                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setCurso(curso);
                inscripcion.setAlumno(alumno);
                inscripcion.setTutor(tutor);
                inscripcion.setFechaInscripcion(LocalDate.now());
                inscripcion.setEstado_inscripcion(EstadoInscripcion.RESERVADA);
                inscripcion.setPago(pago);
                inscripcionRepository.save(inscripcion);

                return pagoMapper.convertToDTO(pago);
            }
            else{
                throw new ResourceNotFoundException("El tutor no dicta ese curso");
            }
        }
    }

    @Transactional
    public PaypalResponseDTO verificarPago(int idPago) {
        Pago pago = pagoRepository.findById(idPago);

        if (pago == null) {
            throw new ResourceNotFoundException("El pago no existe");
        }
        else{
            pago.setEstado(EstadoPago.COMPLETADO);
            pagoRepository.save(pago);
            Inscripcion inscripcion = inscripcionRepository.findByPago(pago);
            if (inscripcion == null) {
                throw new ResourceNotFoundException("No hay inscripcion vinvulada a este pago");
            }
            else{
                inscripcion.setEstado_inscripcion(EstadoInscripcion.CONFIRMADA);
                inscripcionRepository.save(inscripcion);

                PaypalResponseDTO paypalResponseDTO = new PaypalResponseDTO();
                paypalResponseDTO.setPago(pago);
                paypalResponseDTO.setCurso(inscripcion.getCurso());

                return paypalResponseDTO;
            }
        }

    }
}
