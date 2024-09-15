package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface BusquedaTutorRepository extends JpaRepository<Tutor, Integer> {

    @Query("SELECT DISTINCT t FROM Tutor t " +
            "JOIN t.valoraciones v " +
            "JOIN t.horarios h " +
            "WHERE v.calificacion BETWEEN :calificacionMinima AND :calificacionMaxima " +
            "AND t.tarifaBase BETWEEN :tarifaMinima AND :tarifaMaxima " +
            "AND h.diaSemana LIKE %:diaSemana% " +
            "AND h.horaInicio <= :horaFin " +
            "AND h.horaFin >= :horaInicio")
    List<Tutor> findByCalificacionBetweenAndTarifaBaseBetweenAndDisponibilidadContaining(
            @Param("calificacionMinima") Integer calificacionMinima,
            @Param("calificacionMaxima") Integer calificacionMaxima,
            @Param("tarifaMinima") BigDecimal tarifaMinima,
            @Param("tarifaMaxima") BigDecimal tarifaMaxima,
            @Param("diaSemana") String diaSemana,
            @Param("horaInicio") String horaInicio,
            @Param("horaFin") String horaFin);
}
