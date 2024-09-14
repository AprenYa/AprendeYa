package com.aprendeya.aprendeyaapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Inscripciones")
@Data
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_inscripcion")
    private Integer idInscripcion;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "id_pago", nullable = false)
    private Pago pago;


    @Column(name = "fecha_inscripcion", nullable = false)
    private LocalDate fechaInscripcion;
}
