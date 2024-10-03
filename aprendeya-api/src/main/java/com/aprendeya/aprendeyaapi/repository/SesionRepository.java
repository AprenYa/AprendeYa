package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Curso;
import com.aprendeya.aprendeyaapi.model.entity.Sesion;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SesionRepository extends JpaRepository<Sesion, Integer>  {

    @Query("SELECT s FROM Sesion s  WHERE s.curso=:curso")
    List<Sesion> buscarSesionesPorCurso(@Param("curso") Curso curso);

    List<Sesion> findByTutor(Tutor tutor);

}