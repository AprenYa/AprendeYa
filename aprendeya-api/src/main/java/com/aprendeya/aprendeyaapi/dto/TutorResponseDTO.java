package com.aprendeya.aprendeyaapi.dto;

import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TutorResponseDTO {

    private Integer idTutor;
    private Usuario usuario;
    private String especialidad;
    private Integer experiencia;
    private BigDecimal tarifaBase;

}
