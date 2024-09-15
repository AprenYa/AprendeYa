package com.aprendeya.aprendeyaapi.service.impl;

import com.aprendeya.aprendeyaapi.model.entity.Tutor;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BusquedaTutorRepositoryImpl implements BusquedaTutorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Tutor> buscarTutoresConFiltros(Double calificacionMinima, Double calificacionMaxima,
                                               Double tarifaMinima, Double tarifaMaxima,
                                               String disponibilidad) {
        // Crear CriteriaBuilder y CriteriaQuery
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tutor> query = cb.createQuery(Tutor.class);  // Corregir TTutor.class a Tutor.class
        Root<Tutor> tutor = query.from(Tutor.class);

        // Crear lista de predicados (condiciones) para los filtros
        List<Predicate> predicates = new ArrayList<>();

        // Filtro por calificaciones
        if (calificacionMinima != null) {
            predicates.add(cb.greaterThanOrEqualTo(tutor.get("calificacion"), calificacionMinima));
        }
        if (calificacionMaxima != null) {
            predicates.add(cb.lessThanOrEqualTo(tutor.get("calificacion"), calificacionMaxima));
        }

        // Filtro por tarifas
        if (tarifaMinima != null) {
            predicates.add(cb.greaterThanOrEqualTo(tutor.get("tarifa"), tarifaMinima));
        }
        if (tarifaMaxima != null) {
            predicates.add(cb.lessThanOrEqualTo(tutor.get("tarifa"), tarifaMaxima));
        }

        // Filtro por disponibilidad
        if (disponibilidad != null && !disponibilidad.isEmpty()) {
            predicates.add(cb.equal(tutor.get("disponibilidad"), disponibilidad));
        }

        // Aplicar los predicados a la consulta
        query.where(cb.and(predicates.toArray(new Predicate[0])));

        // Ejecutar la consulta y retornar la lista de tutores filtrados
        return entityManager.createQuery(query).getResultList();
    }
}
