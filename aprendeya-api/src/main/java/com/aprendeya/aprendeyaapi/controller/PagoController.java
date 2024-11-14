package com.aprendeya.aprendeyaapi.controller;

import com.aprendeya.aprendeyaapi.dto.PagoRequestDTO;
import com.aprendeya.aprendeyaapi.dto.PagoResponseDTO;
import com.aprendeya.aprendeyaapi.service.impl.PagosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagos")
@AllArgsConstructor
public class PagoController {

    private final PagosService pagosService;

    @PostMapping
    public ResponseEntity<PagoResponseDTO> pagar(@RequestBody PagoRequestDTO pagoRequestDTO) {
        PagoResponseDTO pagoResponseDTO = pagosService.notificarPago(pagoRequestDTO);
        return new ResponseEntity<>(pagoResponseDTO, HttpStatus.CREATED);
    }
}
