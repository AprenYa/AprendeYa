package com.aprendeya.aprendeyaapi.dto;

import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Sesion;
import com.aprendeya.aprendeyaapi.model.enums.EstadoAsistencia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AsistenciaResponseDTO {

    private Integer idAsistencia;
    private Sesion sesion;
    private Alumno alumno;
    private LocalDateTime fecha;
    private EstadoAsistencia estado;
}
