package com.aprendeya.aprendeyaapi.api;

import com.aprendeya.aprendeyaapi.dto.TutorPerfilDTO;
import com.aprendeya.aprendeyaapi.service.TutorServices;
import com.aprendeya.aprendeyaapi.service.impl.TutorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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
    @GetMapping("/filtrar")
    public List<TutorPerfilDTO> findTutoresByFilters(
            @RequestParam(required = false) String especialidad,
            @RequestParam(required = false) Integer experiencia,
            @RequestParam(required = false) BigDecimal tarifaBase) {
        return tutorService.findTutoresByFilters(especialidad, experiencia, tarifaBase);
    }
}
