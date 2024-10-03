package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.AlumnoPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.AlumnoResponseDTO;
import com.aprendeya.aprendeyaapi.exception.ResourceNotFoundException;
import com.aprendeya.aprendeyaapi.mapper.AlumnoMapper;
import com.aprendeya.aprendeyaapi.model.entity.*;
import com.aprendeya.aprendeyaapi.repository.*;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AlumnoService {

    private final AlumnoRepository alumnoRepository;
    private final PadreRepository padreRepository;
    private final AsistenciaRepository asistenciaRepository;
    private final EvaluacionRepository evaluacionRepository;
    private final InscripcionRepository inscripcionRepository;
    private final PagoRepository pagoRepository;
    private final ValoracionTutorRepository valoracionTutorRepository;
    private final AlumnoMapper alumnoMapper;
    private final EntityManager entityManager;

    @Transactional
    public AlumnoResponseDTO editarPerfil(AlumnoPerfilRequestDTO alumnoPerfilRequestDTO, int idAlumno) {
        Alumno alumno = alumnoRepository.buscarAlumnoPorID(idAlumno);

        if (alumno == null) {
            throw new ResourceNotFoundException("El alumno con el ID " + idAlumno + " no existe.");
        }

        alumnoRepository.actualizarDescripcion(idAlumno, alumnoPerfilRequestDTO.getDescripcion());
        entityManager.refresh(alumno);
        Alumno alumnoActualizado = alumnoRepository.buscarAlumnoPorID(idAlumno);

        return alumnoMapper.convertToDTO(alumnoActualizado);
    }

    @Transactional
    public void eliminarPerfil(Integer id) {

        Alumno alumno = alumnoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El alumno no existe"));

        Optional<Padre> padresAsociados = padreRepository.findByAlumno(alumno);
        if (!padresAsociados.isEmpty()) {
            List<Padre> padres = padresAsociados.stream().toList();
            padreRepository.deleteAll(padres);
        }

        List<Evaluacion> evaluaciones = evaluacionRepository.findByAlumno(alumno);
        if (!evaluaciones.isEmpty()) {
            evaluacionRepository.deleteAll(evaluaciones);
        }

        List<Asistencia> asistencias = asistenciaRepository.findByAlumno(alumno);
        if (!asistencias.isEmpty()) {
            asistenciaRepository.deleteAll(asistencias);
        }

        List<Inscripcion> inscripciones = inscripcionRepository.findByAlumno(alumno);
        if (!inscripciones.isEmpty()) {
            inscripcionRepository.deleteAll(inscripciones);
        }

        List<Pago> pagos = pagoRepository.findByAlumno(alumno);
        if (!pagos.isEmpty()) {
            pagoRepository.deleteAll(pagos);
        }

        List<ValoracionTutor> valoracionTutores = valoracionTutorRepository.findByAlumno(alumno);
        if (!valoracionTutores.isEmpty()) {
            valoracionTutorRepository.deleteAll(valoracionTutores);
        }

        alumnoRepository.deleteById(id);

    }
}
