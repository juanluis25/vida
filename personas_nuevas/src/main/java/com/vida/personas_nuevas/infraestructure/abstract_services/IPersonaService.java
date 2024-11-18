package com.vida.personas_nuevas.infraestructure.abstract_services;

import com.vida.personas_nuevas.infraestructure.util.SortType;
import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.GrupoResponse;
import com.vida.personas_nuevas.models.response.PersonaResponse;
import org.springframework.data.domain.Page;

import java.util.Set;

public interface IPersonaService extends CrudService<PersonaRequest, PersonaResponse, Long>{

    Page<PersonaResponse> readAll(Integer page, Integer size, SortType sortType);

    Set<GrupoResponse> categoriaGrupoPorEdades();
}
