package com.aprendeya.aprendeyaapi.controller;

import com.aprendeya.aprendeyaapi.dto.TutorPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.TutorResponseDTO;
import com.aprendeya.aprendeyaapi.service.impl.TutorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/materia")
    public ResponseEntity<List<TutorResponseDTO>> buscarTutoresPorMateria(@RequestBody String nombreCurso){
        List<TutorResponseDTO> tutorResponseDTOS = tutorService.buscarTutoresPorMateria(nombreCurso);
        return new ResponseEntity<>(tutorResponseDTOS, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarTutor(@PathVariable int id){
        tutorService.eliminarPerfil(id);
        return new ResponseEntity<>("El tutor se ha eliminado correctamente", HttpStatus.OK);
    }
}
