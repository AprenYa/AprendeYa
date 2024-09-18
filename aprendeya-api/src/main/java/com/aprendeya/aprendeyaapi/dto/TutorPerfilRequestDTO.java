package com.aprendeya.aprendeyaapi.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorPerfilRequestDTO {

    @NotBlank(message = "La especialidad no puede estar vacia")
    private String especialidad;

    @NotNull(message = "La cantidad de años de experiencia no puede estar vacia")
    @Min(value = 0, message = "Los años de experiencia debe ser mayor que 0")
    private Integer experiencia;

    @NotNull(message = "La tarifa base no puede estar vacia")
    @Min(value = 0, message = "La tarifa base debe ser mayor que 0")
    private BigDecimal tarifaBase;
}
