package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Evaluacion;
import com.aprendeya.aprendeyaapi.model.entity.Sesion;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EvaluacionRepository extends CrudRepository<Evaluacion, Integer> {

    List<Evaluacion> findByAlumno(Alumno alumno);

    List<Evaluacion> findBySesion(Sesion sesion);
}
