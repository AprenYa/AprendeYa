package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.TutorPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.TutorResponseDTO;
import com.aprendeya.aprendeyaapi.exception.ResourceNotFoundException;
import com.aprendeya.aprendeyaapi.mapper.TutorMapper;
import com.aprendeya.aprendeyaapi.model.entity.Curso;
import com.aprendeya.aprendeyaapi.model.entity.Sesion;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.repository.CursoRepository;
import com.aprendeya.aprendeyaapi.repository.SesionRepository;
import com.aprendeya.aprendeyaapi.repository.TutorRepository;
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
}
