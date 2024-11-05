package com.vida.personas_nuevas.infraestructure.abstract_services;

import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.PersonaResponse;

public interface IPersonaService extends CrudService<PersonaRequest, PersonaResponse, Long>{

}
