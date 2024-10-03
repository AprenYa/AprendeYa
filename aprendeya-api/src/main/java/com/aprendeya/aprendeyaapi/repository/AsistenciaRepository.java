package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Asistencia;
import com.aprendeya.aprendeyaapi.model.entity.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AsistenciaRepository extends JpaRepository<Asistencia, Integer> {

    List<Asistencia> findByAlumno(Alumno alumno);

    List<Asistencia> findBySesion(Sesion sesion);
}
