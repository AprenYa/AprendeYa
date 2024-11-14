package com.aprendeya.aprendeyaapi.dto;

import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.model.enums.EstadoPago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoResponseDTO {

    private Integer idPago;
    private Alumno alumno;
    private Tutor tutor;
    private BigDecimal monto;
    private EstadoPago estado;
    private LocalDate fechaPago;
}
