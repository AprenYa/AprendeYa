package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Alumno;
import com.aprendeya.aprendeyaapi.model.entity.Padre;
import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PadreRepository extends JpaRepository<Padre, Integer> {
    void deleteByUsuario(Usuario usuario);
    Optional<Padre> findByAlumno(Alumno alumno);

}
