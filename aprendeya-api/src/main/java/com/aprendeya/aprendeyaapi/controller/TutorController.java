package com.aprendeya.aprendeyaapi.controller;

import com.aprendeya.aprendeyaapi.dto.TutorPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.TutorResponseDTO;
import com.aprendeya.aprendeyaapi.service.impl.TutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutores")
@AllArgsConstructor

public class TutorController {

    private final TutorService tutorService;

    @PutMapping("/{id}")
    public ResponseEntity<TutorResponseDTO> editarPerfil(@PathVariable int id, @Valid @RequestBody TutorPerfilRequestDTO tutorPerfilRequestDTO){
        TutorResponseDTO tutorResponseDTO = tutorService.editarPerfil(tutorPerfilRequestDTO, id);
        return new ResponseEntity<>(tutorResponseDTO, HttpStatus.OK);
    }
}
