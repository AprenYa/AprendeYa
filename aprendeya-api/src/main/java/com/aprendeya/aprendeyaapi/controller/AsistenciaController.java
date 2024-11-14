package com.aprendeya.aprendeyaapi.controller;

import com.aprendeya.aprendeyaapi.dto.AsistenciaRequestDTO;
import com.aprendeya.aprendeyaapi.dto.AsistenciaResponseDTO;
import com.aprendeya.aprendeyaapi.service.impl.AsistenciaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/asistencias")
@AllArgsConstructor
public class AsistenciaController {

    private final AsistenciaService asistenciaService;

    @GetMapping
    public ResponseEntity<AsistenciaResponseDTO> buscarAsistencia(@Valid @RequestBody AsistenciaRequestDTO asistenciaRequestDTO) {
        AsistenciaResponseDTO asistenciaResponseDTO = asistenciaService.buscarAsistencias(asistenciaRequestDTO);
        return new ResponseEntity<>(asistenciaResponseDTO, HttpStatus.OK);
    }
}
