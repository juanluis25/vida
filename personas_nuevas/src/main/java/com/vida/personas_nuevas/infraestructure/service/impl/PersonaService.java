package com.vida.personas_nuevas.infraestructure.service.impl;

import com.vida.personas_nuevas.entities.PersonaEntity;
import com.vida.personas_nuevas.infraestructure.abstract_services.IPersonaService;
import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.PersonaResponse;
import com.vida.personas_nuevas.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yaml.snakeyaml.events.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class PersonaService implements IPersonaService {

    private final PersonaRepository personaRepository;
    @Override
    public PersonaResponse crear(PersonaRequest personaRequest) {

        var registrarPersona = PersonaEntity.builder()
                .fecha(LocalDateTime.now())
                .nombre(personaRequest.getNombre())
                .apellidopaterno(personaRequest.getApellidoPaterno())
                .apellidomaterno(personaRequest.getApellidoMaterno())
                .edad(personaRequest.getEdad())
                .telefono(personaRequest.getTelefono())
                .estadocivil(personaRequest.getEstadoCivil())
                .comosupistedeiglesia(personaRequest.getComoSupisteDeIglesia())
                .colonia(personaRequest.getColonia())
                .nombrevoluntario(personaRequest.getNombreVoluntario())
                .condicionvisita(personaRequest.getCondicionVisita())
                .grupopequeñointeres(personaRequest.getGrupoPequeñoInteres())
                .build();

        var personaRegistrada = personaRepository.save(registrarPersona);
        log.info("Personas registrada con id: {}",personaRegistrada.getId());
        return this.entityToResponse(personaRegistrada);
    }

    @Override
    public PersonaResponse obtener(Long id) {
        var obtenerPersona = this.personaRepository.findById(id).orElseThrow();
        return this.entityToResponse(obtenerPersona);
    }

    @Override
    public PersonaResponse actualizar(PersonaRequest personaRequest, Long id) {
        var actualizarPersona = this.personaRepository.findById(id).orElseThrow();
        actualizarPersona.setNombre(personaRequest.getNombre());
        actualizarPersona.setApellidomaterno(personaRequest.getApellidoPaterno());
        actualizarPersona.setApellidomaterno(personaRequest.getApellidoMaterno());
        actualizarPersona.setEdad(personaRequest.getEdad());
        actualizarPersona.setEstadocivil(personaRequest.getEstadoCivil());
        actualizarPersona.setComosupistedeiglesia(personaRequest.getComoSupisteDeIglesia());
        actualizarPersona.setColonia(personaRequest.getColonia());
        actualizarPersona.setNombrevoluntario(personaRequest.getNombreVoluntario());
        actualizarPersona.setCondicionvisita(personaRequest.getCondicionVisita());
        actualizarPersona.setGrupopequeñointeres(personaRequest.getGrupoPequeñoInteres());

        var personasActualizada = this.personaRepository.save(actualizarPersona);
        log.info("La personas se actualizó {}", personasActualizada);
        return this.entityToResponse(personasActualizada);
    }

    @Override
    public void borrar(Long id) {
        var borrarPersona = this.personaRepository.findById(id).orElseThrow();
        this.personaRepository.delete(borrarPersona);
        log.info("La persona fue borrada {}", borrarPersona);
    }
    private PersonaResponse entityToResponse (PersonaEntity entity){
        var response = new PersonaResponse();
        BeanUtils.copyProperties(entity, response);
        return response;
    }
}
