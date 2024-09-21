package com.aprendeya.aprendeyaapi.api;

import com.aprendeya.aprendeyaapi.dto.TutorPerfilDTO;
import com.aprendeya.aprendeyaapi.service.TutorServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tutores")
public class CustomTutorController {

    @Autowired
    private TutorServices tutorService;

    @GetMapping
    public ResponseEntity<List<TutorPerfilDTO>> getAllTutores() {
        List<TutorPerfilDTO> tutores = tutorService.getAllTutores();
        return ResponseEntity.ok(tutores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TutorPerfilDTO> getTutorById(@PathVariable Integer id) {
        TutorPerfilDTO tutorPerfil = tutorService.getTutorById(id);
        return ResponseEntity.ok(tutorPerfil);
    }
}
