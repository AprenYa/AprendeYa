package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.dto.CustomTutorPerfilDTO;
import com.aprendeya.aprendeyaapi.dto.HorarioDTO;
import com.aprendeya.aprendeyaapi.dto.TutorPerfilDTO;
import com.aprendeya.aprendeyaapi.dto.ValoracionDTO;
import com.aprendeya.aprendeyaapi.model.entity.Horario;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.model.entity.ValoracionTutor;
import com.aprendeya.aprendeyaapi.repository.HorarioRepository;
import com.aprendeya.aprendeyaapi.repository.ValoracionTutorRepository;
import com.aprendeya.aprendeyaapi.repository.aTutorRepository;
import com.aprendeya.aprendeyaapi.service.TutorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TutorServiceImpl implements TutorServices {

    @Autowired
    private aTutorRepository tutorRepository;

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

    @Override
    public List<TutorPerfilDTO> findTutoresByFilters(String especialidad, Integer experiencia, BigDecimal tarifaBase) {
        List<Tutor> tutores = tutorRepository.findAll();

        if (especialidad != null && !especialidad.isEmpty()) {
            tutores = tutores.stream()
                    .filter(tutor -> tutor.getEspecialidad().equalsIgnoreCase(especialidad))
                    .collect(Collectors.toList());
        }

        if (experiencia != null) {
            tutores = tutores.stream()
                    .filter(tutor -> tutor.getExperiencia().equals(experiencia))
                    .collect(Collectors.toList());
        }

        if (tarifaBase != null) {
            tutores = tutores.stream()
                    .filter(tutor -> tutor.getTarifaBase().compareTo(tarifaBase) == 0)
                    .collect(Collectors.toList());
        }

        return tutores.stream()
                .map(this::convertToPerfilDTO)
                .collect(Collectors.toList());
    }
    @Override
    public CustomTutorPerfilDTO actualizarPerfil(Integer idTutor, CustomTutorPerfilDTO tutorPerfilDTO) {
        Tutor tutor = tutorRepository.findById(idTutor)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        tutor.setEspecialidad(tutorPerfilDTO.getEspecialidad());
        tutor.setExperiencia(tutorPerfilDTO.getExperiencia());
        tutor.setTarifaBase(tutorPerfilDTO.getTarifaBase()); // Aquí es importante que el valor no sea nulo.

        tutorRepository.save(tutor);
        actualizarHorarios(tutor.getIdTutor(), tutorPerfilDTO.getHorarios());

        return convertToCustomPerfil(tutor);
    }



    public void actualizarHorarios(Integer idTutor, List<HorarioDTO> horariosDTO) {
        Tutor tutor = tutorRepository.findById(idTutor)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));

        // Eliminar los horarios existentes
        horarioRepository.deleteByTutorIdTutor(tutor.getIdTutor());


        // Agregar los nuevos horarios
        for (HorarioDTO horarioDTO : horariosDTO) {

            if (horarioDTO.getDiaSemana() == null) {
                throw new RuntimeException("El día de la semana no puede ser nulo");
            }
            Horario horario = new Horario();
            horario.setDiaSemana(horarioDTO.getDiaSemana());
            horario.setHoraInicio(horarioDTO.getHoraInicio());
            horario.setHoraFin(horarioDTO.getHoraFin());
            horario.setTutor(tutor);  // Asociar el horario al tutor
            horarioRepository.save(horario);
        }
    }

    @Override
    public TutorPerfilDTO obtenerPerfil(Integer idTutor) {
        Tutor tutor = tutorRepository.findById(idTutor)
                .orElseThrow(() -> new RuntimeException("Tutor no encontrado"));
        return convertToPerfilDTO(tutor);
    }
    private CustomTutorPerfilDTO convertToCustomPerfil(Tutor tutor) {
        CustomTutorPerfilDTO dto = new CustomTutorPerfilDTO();

        dto.setEspecialidad(tutor.getEspecialidad());
        dto.setExperiencia(tutor.getExperiencia());
        dto.setTarifaBase(tutor.getTarifaBase());

        List<HorarioDTO> horarios = horarioRepository.findByTutorIdTutor(tutor.getIdTutor())
                .stream().map(this::convertToHorarioDTO).collect(Collectors.toList());
        dto.setHorarios(horarios);

        return dto;
    }

    private TutorPerfilDTO convertToPerfilDTO(Tutor tutor) {
        TutorPerfilDTO dto = new TutorPerfilDTO();
        dto.setIdTutor(tutor.getIdTutor());
        dto.setNombreTutor(tutor.getUsuario().getNombre() + " " + tutor.getUsuario().getApellido());
        dto.setEspecialidad(tutor.getEspecialidad());
        dto.setExperiencia(tutor.getExperiencia());
        dto.setTarifaBase(tutor.getTarifaBase());

        List<HorarioDTO> horarios = horarioRepository.findByTutorIdTutor(tutor.getIdTutor())
                .stream().map(this::convertToHorarioDTO).collect(Collectors.toList());
        dto.setHorarios(horarios);

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
