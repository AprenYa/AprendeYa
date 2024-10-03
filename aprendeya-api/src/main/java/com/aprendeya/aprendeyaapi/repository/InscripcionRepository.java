package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Horario;
import com.aprendeya.aprendeyaapi.model.entity.Inscripcion;
import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InscripcionRepository extends CrudRepository<Inscripcion, Integer> {

    List<Inscripcion> findByAlumno(Alumno alumno);

    List<Inscripcion> findByTutor(Tutor tutor);

}
