package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.*;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InscripcionRepository extends CrudRepository<Inscripcion, Integer> {

    List<Inscripcion> findByAlumno(Alumno alumno);

    List<Inscripcion> findByTutor(Tutor tutor);

    Inscripcion findByPago(Pago pago);
}
