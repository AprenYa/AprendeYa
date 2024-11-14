package com.aprendeya.aprendeyaapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagoRequestDTO {

    @NotNull(message = "El ID del alumno mo puede estar vacio")
    private int idAlumno;
    @NotBlank(message = "El nombre del curso no puede estar en blanco")
    private String nombreCurso;
    @NotNull(message = "El Id del tutor no puede estar vacio")
    private int idTutor;
}
