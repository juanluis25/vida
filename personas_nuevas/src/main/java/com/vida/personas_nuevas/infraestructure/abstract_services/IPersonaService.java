package com.vida.personas_nuevas.infraestructure.abstract_services;

import com.vida.personas_nuevas.entities.PersonaEntity;
import com.vida.personas_nuevas.infraestructure.util.SortType;
import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.PersonaResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface IPersonaService extends CrudService<PersonaRequest, PersonaResponse, Long>{

    Page<PersonaResponse> readAll(Integer page, Integer size, SortType sortType);

    Set<PersonaResponse> findAll();

    Optional<List<PersonaEntity>> filtrarPersonas(String nombre, String apellidopaterno, String apellidomaterno, String telefono);
}
