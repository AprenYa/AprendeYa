package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

    @Query("SELECT c FROM Curso c WHERE c.nombreCurso=:nombreCurso")
    Curso buscarCursoPorNombre(@Param("nombreCurso") String nombreCurso);
}
