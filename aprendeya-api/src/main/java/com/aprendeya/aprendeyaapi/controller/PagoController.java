package com.aprendeya.aprendeyaapi.controller;

import com.aprendeya.aprendeyaapi.dto.PagoRequestDTO;
import com.aprendeya.aprendeyaapi.dto.PagoResponseDTO;
import com.aprendeya.aprendeyaapi.dto.PaypalResponseDTO;
import com.aprendeya.aprendeyaapi.service.impl.PagosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/{id}")
    public ResponseEntity<PaypalResponseDTO> editar(@PathVariable int id) {
        PaypalResponseDTO paypalResponseDTO = pagosService.verificarPago(id);
        return new ResponseEntity<>(paypalResponseDTO, HttpStatus.OK);
    }
}
