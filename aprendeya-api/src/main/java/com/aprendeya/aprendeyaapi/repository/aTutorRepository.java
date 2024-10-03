package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import com.aprendeya.aprendeyaapi.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface aTutorRepository extends JpaRepository<Tutor, Integer> {
    void deleteByUsuario(Usuario usuario);
}
