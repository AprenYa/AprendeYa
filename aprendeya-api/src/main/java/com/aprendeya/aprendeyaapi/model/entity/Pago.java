package com.aprendeya.aprendeyaapi.model.entity;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Table(name = "Pagos")
@Data
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pago")
    private Integer idPago;

    @ManyToOne
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false)
    private Tutor tutor;

    @Column(name = "monto", nullable = false, precision = 10, scale = 2)
    private Float monto;

    @Column(name = "estado", nullable = false)
    @Enumerated(EnumType.STRING)
    private EstadoPago estado;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    public enum EstadoPago {
        PENDIENTE,
        COMPLETADO,
        CANCELADO
    }
}
