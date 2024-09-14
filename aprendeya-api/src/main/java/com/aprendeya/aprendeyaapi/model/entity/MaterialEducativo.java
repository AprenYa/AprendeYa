package com.aprendeya.aprendeyaapi.model.entity;

import com.aprendeya.aprendeyaapi.model.enums.TipoMaterial;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "MaterialesEducativos")
@Data
public class MaterialEducativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_material")
    private Integer idMaterial;

    @ManyToOne
    @JoinColumn(name = "id_sesion", nullable = false)
    private Sesion sesion;

    @Column(name = "tipo_material", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMaterial tipoMaterial;

    @Column(name = "nombre_material", nullable = false, length = 255)
    private String nombreMaterial;

    @Column(name = "url_material")
    private String urlMaterial;

    @Column(name = "fecha_subida", nullable = false)
    private LocalDate fechaSubida;


}
