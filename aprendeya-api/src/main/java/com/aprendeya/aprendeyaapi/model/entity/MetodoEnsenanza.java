package com.aprendeya.aprendeyaapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import lombok.Data;

@Entity
@Table(name = "metodos_ensenanza")
@Data
public class MetodoEnsenanza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_metodo_ensenanza")
    private Integer idMetodoEnsenanza;

    @Column(name = "nombre_metodo", nullable = false, unique = true, length = 100)
    private String nombreMetodo;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
}
