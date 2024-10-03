package com.aprendeya.aprendeyaapi.service;

import com.aprendeya.aprendeyaapi.dto.CustomTutorPerfilDTO;
import com.aprendeya.aprendeyaapi.dto.TutorPerfilDTO;

import java.math.BigDecimal;
import java.util.List;

public interface TutorServices {
    List<TutorPerfilDTO> getAllTutores();
    TutorPerfilDTO getTutorById(Integer idTutor);
    List<TutorPerfilDTO> findTutoresByFilters(String especialidad, Integer experiencia, BigDecimal tarifaBase);
    CustomTutorPerfilDTO actualizarPerfil(Integer idTutor, CustomTutorPerfilDTO tutorPerfilDTO);
    TutorPerfilDTO obtenerPerfil(Integer idTutor);
}

