package com.aprendeya.aprendeyaapi.controller;

import com.aprendeya.aprendeyaapi.dto.AlumnoPerfilRequestDTO;
import com.aprendeya.aprendeyaapi.dto.AlumnoResponseDTO;
import com.aprendeya.aprendeyaapi.service.impl.AlumnoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alumnos")
@AllArgsConstructor

public class AlumnoController {

    private final AlumnoService alumnoService;

    @PutMapping("/{id}")
    public ResponseEntity<AlumnoResponseDTO> editarPerfil(@PathVariable int id, @Valid @RequestBody AlumnoPerfilRequestDTO alumnoPerfilRequestDTO){
        AlumnoResponseDTO alumnoResponseDTO = alumnoService.editarPerfil(alumnoPerfilRequestDTO, id);
        return new ResponseEntity<>(alumnoResponseDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarAlumno(@PathVariable int id){
        alumnoService.eliminarPerfil(id);
        return new ResponseEntity<>("El alumno se ha eliminado correctamente", HttpStatus.OK);
    }
}
