package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.TutorPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.TutorResponseDTO;
import com.aprendeya.aprendeyaapi.exception.ResourceNotFoundException;
import com.aprendeya.aprendeyaapi.mapper.TutorMapper;
import com.aprendeya.aprendeyaapi.model.entity.*;
import com.aprendeya.aprendeyaapi.repository.*;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@AllArgsConstructor
public class TutorService {

    private final TutorRepository tutorRepository;
    private final CursoRepository cursoRepository;
    private final SesionRepository sesionRepository;
    private final HorarioRepository horarioRepository;
    private final InscripcionRepository inscripcionRepository;
    private final PagoRepository pagoRepository;
    private final ValoracionTutorRepository valoracionTutorRepository;
    private final AsistenciaRepository asistenciaRepository;
    private final EvaluacionRepository evaluacionRepository;
    private final MaterialEducativoRepository materialEducativoRepository;
    private final TutorMapper tutorMapper;
    private final EntityManager entityManager;

    @Transactional
    public TutorResponseDTO editarPerfil(TutorPerfilRequestDTO tutorPerfilRequestDTO, int idTutor){
        Tutor tutor = tutorRepository.buscarTutorPorID(idTutor);

        if(tutor == null){
            throw new ResourceNotFoundException("El tutor con el ID "+idTutor+" no existe.");
        }

        tutorRepository.actualizarPerfil(tutorPerfilRequestDTO.getEspecialidad(), tutorPerfilRequestDTO.getExperiencia(), tutorPerfilRequestDTO.getTarifaBase(), idTutor);
        entityManager.refresh(tutor);
        Tutor tutorActualizado = tutorRepository.buscarTutorPorID(idTutor);

        return tutorMapper.convertToDTO(tutorActualizado);
    }

    @Transactional
    public List<TutorResponseDTO> buscarTutoresPorMateria(String nombreCurso){
        Curso curso = cursoRepository.buscarCursoPorNombre(nombreCurso);
        List<Sesion> sesiones;
        List<Tutor> tutores = new ArrayList<>();

        if(curso == null){
            throw new ResourceNotFoundException("No existe el curso");
        }
        else{
            sesiones = sesionRepository.buscarSesionesPorCurso(curso);

            if(sesiones.isEmpty()){
                throw new ResourceNotFoundException("No hay tutores para este curso");
            }
            else{
                for(Sesion sesion : sesiones){
                    Tutor tutorNuevo = tutorRepository.buscarTutorPorID(sesion.getTutor().getIdTutor());
                    tutores.add(tutorNuevo);
                }
            }
        }
        return tutorMapper.convertToListDTO(tutores);
    }

    @Transactional
    public void eliminarPerfil(Integer id){

        Tutor tutor = tutorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("El tutor no existe"));

        List<Horario> horarios = horarioRepository.findByTutor(tutor);
        if (!horarios.isEmpty()) {
            horarioRepository.deleteAll(horarios);
        }

        List<Inscripcion> inscripciones = inscripcionRepository.findByTutor(tutor);
        if (!inscripciones.isEmpty()) {
            inscripcionRepository.deleteAll(inscripciones);
        }

        List<Pago> pagos = pagoRepository.findByTutor(tutor);
        if (!pagos.isEmpty()) {
            pagoRepository.deleteAll(pagos);
        }

        List<ValoracionTutor> valoracionTutores = valoracionTutorRepository.findByTutor(tutor);
        if (!valoracionTutores.isEmpty()) {
            valoracionTutorRepository.deleteAll(valoracionTutores);
        }

        List<Sesion> sesiones = sesionRepository.findByTutor(tutor);

        for (Sesion sesion : sesiones) {
            List<Asistencia> asistencias = asistenciaRepository.findBySesion(sesion);
            if (!asistencias.isEmpty()) {
                asistenciaRepository.deleteAll(asistencias);
            }

            List<Evaluacion> evaluaciones = evaluacionRepository.findBySesion(sesion);
            if (!evaluaciones.isEmpty()) {
                evaluacionRepository.deleteAll(evaluaciones);
            }

            List<MaterialEducativo> materialEducativos = materialEducativoRepository.findBySesion(sesion);
            if (!materialEducativos.isEmpty()) {
                materialEducativoRepository.deleteAll(materialEducativos);
            }
        }

        if(!sesiones.isEmpty()){
            sesionRepository.deleteAll(sesiones);
        }

        tutorRepository.deleteById(id);
    }
}
