package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface TutorRepository extends JpaRepository<Tutor, Integer> {

    @Query("SELECT t FROM Tutor t JOIN FETCH t.usuario WHERE t.idTutor=:idTutor")
    Tutor buscarTutorPorID(@Param("idTutor") Integer idTutor);

    @Modifying
    @Query("UPDATE Tutor t SET t.especialidad =:especialidad, t.experiencia=:experiencia, t.tarifaBase=:tarifaBase WHERE t.idTutor=:idTutor")
    void actualizarPerfil(@Param("especialidad") String especialidad, @Param("experiencia") Integer experiencia, @Param("tarifaBase") BigDecimal tarifaBase, @Param("idTutor") Integer idTutor);
}
