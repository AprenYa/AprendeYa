package com.aprendeya.aprendeyaapi.service.impl;
import com.aprendeya.aprendeyaapi.repository.TutorRepository;

import com.aprendeya.aprendeyaapi.dto.HorarioDTO;
import com.aprendeya.aprendeyaapi.dto.TutorPerfilDTO;
import com.aprendeya.aprendeyaapi.dto.ValoracionDTO;
import com.aprendeya.aprendeyaapi.model.entity.Horario;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.model.entity.ValoracionTutor;
import com.aprendeya.aprendeyaapi.repository.HorarioRepository;
import com.aprendeya.aprendeyaapi.repository.ValoracionTutorRepository;
import com.aprendeya.aprendeyaapi.service.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorServiceImpl implements TutorService {

    @Autowired
    private TutorRepository tutorRepository;

    @Autowired
    private HorarioRepository horarioRepository;

    @Autowired
    private ValoracionTutorRepository valoracionTutorRepository;

    @Override
    public List<TutorPerfilDTO> getAllTutores() {
        return tutorRepository.findAll().stream()
                .map(this::convertToPerfilDTO)
                .collect(Collectors.toList());
    }

    @Override
    public TutorPerfilDTO getTutorById(Integer idTutor) {
        Tutor tutor = tutorRepository.findById(idTutor)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));
        return convertToPerfilDTO(tutor);
    }

    private TutorPerfilDTO convertToPerfilDTO(Tutor tutor) {
        TutorPerfilDTO dto = new TutorPerfilDTO();
        dto.setIdTutor(tutor.getIdTutor());
        dto.setNombreTutor(tutor.getUsuario().getNombre() + " " + tutor.getUsuario().getApellido());
        dto.setEspecialidad(tutor.getEspecialidad());
        dto.setExperiencia(tutor.getExperiencia());
        dto.setTarifaBase(tutor.getTarifaBase());

        // Obtener los horarios del tutor
        List<HorarioDTO> horarios = horarioRepository.findByTutorIdTutor(tutor.getIdTutor())
                .stream().map(this::convertToHorarioDTO).collect(Collectors.toList());
        dto.setHorarios(horarios);

        // Obtener las valoraciones del tutor
        List<ValoracionDTO> valoraciones = valoracionTutorRepository.findByTutorIdTutor(tutor.getIdTutor())
                .stream().map(this::convertToValoracionDTO).collect(Collectors.toList());
        dto.setValoraciones(valoraciones);

        return dto;
    }

    private HorarioDTO convertToHorarioDTO(Horario horario) {
        HorarioDTO dto = new HorarioDTO();
        dto.setDiaSemana(horario.getDiaSemana());
        dto.setHoraInicio(horario.getHoraInicio());
        dto.setHoraFin(horario.getHoraFin());
        return dto;
    }

    private ValoracionDTO convertToValoracionDTO(ValoracionTutor valoracion) {
        ValoracionDTO dto = new ValoracionDTO();
        dto.setCalificacion(valoracion.getCalificacion());
        dto.setComentario(valoracion.getComentario());
        dto.setNombreAlumno(valoracion.getAlumno().getUsuario().getNombre() + " " + valoracion.getAlumno().getUsuario().getApellido());
        return dto;
    }
}
