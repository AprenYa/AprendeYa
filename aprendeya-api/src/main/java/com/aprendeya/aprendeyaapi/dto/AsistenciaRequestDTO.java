package com.aprendeya.aprendeyaapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaRequestDTO {

    @NotNull(message = "El ID de la sesion mo puede estar vacio")
    private int idSesion;
    @NotNull(message = "El ID del alumno mo puede estar vacio")
    private int idAlumno;

    private LocalDateTime fecha;
}
