package com.vida.personas_nuevas.repository;


import com.vida.personas_nuevas.entities.PersonaEntity;
import com.vida.personas_nuevas.models.response.GrupoResponse;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Set;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    @Query(value = "SELECT nombre, grupopequeñointeres FROM fun_obtenergrupo()", nativeQuery = true)
    Set<Object[]> categoriaGrupoPorEdades();
}