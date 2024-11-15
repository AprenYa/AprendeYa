package com.aprendeya.aprendeyaapi.dto;

import com.aprendeya.aprendeyaapi.model.entity.Curso;
import com.aprendeya.aprendeyaapi.model.entity.Pago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaypalResponseDTO {

    private String mensaje = "Tu pago ah sido realizado con exito con Paypal";
    private Pago pago;
    private Curso curso;

}
