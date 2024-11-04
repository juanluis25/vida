package com.vida.personas_nuevas.infraestructure.abstract_services;

import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.PersonaResponse;
import org.yaml.snakeyaml.events.Event;

import java.util.UUID;

public interface IPersonaService extends CrudService<PersonaRequest, PersonaResponse, Long>{

}
