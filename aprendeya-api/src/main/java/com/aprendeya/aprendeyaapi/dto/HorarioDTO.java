package com.aprendeya.aprendeyaapi.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class HorarioDTO {
    private String diaSemana;
    private LocalTime horaInicio;
    private LocalTime horaFin;
}
