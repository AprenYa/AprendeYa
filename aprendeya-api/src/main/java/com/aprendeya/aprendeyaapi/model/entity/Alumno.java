package com.aprendeya.aprendeyaapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "alumnos")

public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private Integer idAlumno;

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)  // Clave foránea referenciada a Usuario
    private Usuario usuario;

    @Column(name = "grado", nullable = false)
    private String grado;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;
}











