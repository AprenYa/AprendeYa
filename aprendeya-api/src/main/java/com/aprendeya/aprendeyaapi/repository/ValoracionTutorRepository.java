package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.ValoracionTutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValoracionTutorRepository extends JpaRepository<ValoracionTutor, Integer> {
    List<ValoracionTutor> findByTutorIdTutor(Integer idTutor);
}
