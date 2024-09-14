package com.aprendeya.aprendeyaapi.model.entity;

import com.aprendeya.aprendeyaapi.model.enums.TipoSesion;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "sesiones")
@Data
public class Sesion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sesion")
    private Integer idSesion;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "id_tutor", nullable = false)
    private Tutor tutor;

    @ManyToOne
    @JoinColumn(name = "id_metodo_ensenanza", nullable = false)
    private MetodoEnsenanza metodoEnsenanza;

    @Column(name = "fecha_sesion", nullable = false)
    private LocalDateTime fechaSesion;

    @Column(name = "orden_sesion")
    private Integer ordenSesion;

    @Column(name = "tema")
    private String tema;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_sesion", nullable = false)
    private TipoSesion tipoSesion;

    @Column(name = "capacidad")
    private Integer capacidad;



}
