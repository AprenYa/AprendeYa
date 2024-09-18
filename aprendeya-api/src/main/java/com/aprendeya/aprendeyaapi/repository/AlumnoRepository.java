package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    @Modifying
    @Query("UPDATE Alumno a SET a.descripcion = :descripcion WHERE a.idAlumno = :id")
    void actualizarDescripcion(@Param("id") Integer id, @Param("descripcion") String descripcion);

    @Query("SELECT a FROM Alumno a JOIN FETCH a.usuario WHERE a.idAlumno=:alumnoID")
    Alumno buscarAlumnoPorID(@Param("alumnoID") Integer alumnoID);

}
