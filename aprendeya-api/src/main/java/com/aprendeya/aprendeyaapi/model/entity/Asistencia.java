package com.aprendeya.aprendeyaapi.model.entity;

import com.aprendeya.aprendeyaapi.model.enums.EstadoAsistencia;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "asistencias")
@Data
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia")
    private Integer idAsistencia;

    @ManyToOne
    @JoinColumn(name = "id_sesion", nullable = false)
    private Sesion sesion;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;

    @Enumerated(EnumType.STRING)
    private EstadoAsistencia estado;


}