package com.aprendeya.aprendeyaapi.repository;

import com.aprendeya.aprendeyaapi.model.entity.MaterialEducativo;
import com.aprendeya.aprendeyaapi.model.entity.Sesion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialEducativoRepository extends JpaRepository<MaterialEducativo, Integer> {

    List<MaterialEducativo> findBySesion(Sesion sesion);
}
