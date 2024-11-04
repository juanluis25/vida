package com.vida.personas_nuevas.repository;


import com.vida.personas_nuevas.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {
}
