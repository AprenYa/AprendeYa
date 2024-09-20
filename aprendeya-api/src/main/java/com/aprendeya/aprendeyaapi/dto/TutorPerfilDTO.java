package com.aprendeya.aprendeyaapi.dto;

import lombok.Data;
import java.time.LocalTime;
import java.math.BigDecimal;
import java.util.List;

@Data
public class TutorPerfilDTO {
    private Integer idTutor;
    private String nombreTutor;
    private String especialidad;
    private Integer experiencia;
    private BigDecimal tarifaBase;
    private List<HorarioDTO> horarios;
    private List<ValoracionDTO> valoraciones;
}
