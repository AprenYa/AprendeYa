package com.aprendeya.aprendeyaapi.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CustomTutorPerfilDTO {
    private String especialidad;
    private Integer experiencia;
    private BigDecimal tarifaBase;
    private List<HorarioDTO> horarios;
}
