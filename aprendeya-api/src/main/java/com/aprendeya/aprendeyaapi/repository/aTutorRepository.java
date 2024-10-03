package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface aTutorRepository extends JpaRepository<Tutor, Integer> {
    // Búsqueda por especialidad, experiencia y tarifa
    @Query("SELECT t FROM Tutor t WHERE " +
            "(:especialidad IS NULL OR t.especialidad = :especialidad) AND " +
            "(:experiencia IS NULL OR t.experiencia >= :experiencia) AND " +
            "(:tarifaBase IS NULL OR t.tarifaBase <= :tarifaBase)")
    List<Tutor> findByFilters(@Param("especialidad") String especialidad,
                              @Param("experiencia") Integer experiencia,
                              @Param("tarifaBase") BigDecimal tarifaBase);
}
