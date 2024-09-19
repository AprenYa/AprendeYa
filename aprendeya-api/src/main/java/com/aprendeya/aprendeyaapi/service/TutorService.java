package com.aprendeya.aprendeyaapi.service;

import com.aprendeya.aprendeyaapi.dto.TutorPerfilDTO;


import java.util.List;

public interface TutorService {
    List<TutorPerfilDTO> getAllTutores();
    TutorPerfilDTO getTutorById(Integer idTutor);
}
