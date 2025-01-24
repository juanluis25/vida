package com.vida.personas_nuevas.repository;


import com.vida.personas_nuevas.entities.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {


    @Query(value = "SELECT p FROM primeravezprueba p WHERE p.nombre ILIKE :nombre%")
    Optional<List<PersonaEntity>> findByNombre(String nombre);

    @Query(value = "SELECT p FROM primeravezprueba p WHERE p.apellidopaterno ILIKE :apellidopaterno%")
    Optional<List<PersonaEntity>> findByApellidopaterno(String apellidopaterno);

    @Query(value = "SELECT p FROM primeravezprueba p WHERE p.apellidomaterno ILIKE :apellidomaterno%")
    Optional<List<PersonaEntity>> findByApellidomaterno(String apellidomaterno);

    @Query(value = "SELECT p FROM primeravezprueba p WHERE p.telefono ILIKE :telefono%")
    Optional<List<PersonaEntity>> findByTelefono(String telefono);
}