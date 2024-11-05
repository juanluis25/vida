package com.vida.personas_nuevas.infraestructure.service.impl;

import static com.vida.personas_nuevas.excepciones.ErrorCodes.INTERNAL_SERVER_ERROR_CODE;
import com.vida.personas_nuevas.excepciones.ErroresExceptions;
import com.vida.personas_nuevas.entities.PersonaEntity;
import com.vida.personas_nuevas.infraestructure.abstract_services.IPersonaService;
import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.PersonaResponse;
import com.vida.personas_nuevas.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;

import static org.apache.logging.log4j.LogManager.getLogger;


@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class PersonaService implements IPersonaService {
    private static final Logger LOGGER = getLogger(PersonaService.class);
    private final PersonaRepository personaRepository;
    @Override
    public PersonaResponse crear(PersonaRequest personaRequest) {
        try {
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
            LOGGER.info("Persona registrada con id: {}", personaRegistrada.getId());
            return this.entityToResponse(personaRegistrada);

        }catch (final Exception exc){
            LOGGER.error(
                    exc.getMessage());

            LOGGER.error(exc);

            throw
                    new ErroresExceptions(
                            INTERNAL_SERVER_ERROR_CODE.name());
        }
    }
    @Override
    public PersonaResponse obtener(Long id) {
        try {
            var obtenerPersona = this.personaRepository.findById(id).orElseThrow();
            LOGGER.info("Persona consultada con id: {}", obtenerPersona.getId());
            return this.entityToResponse(obtenerPersona);

        }catch (final Exception exc){
            LOGGER.error(
                    exc.getMessage());

            LOGGER.error(exc);

            throw
                    new ErroresExceptions(
                            INTERNAL_SERVER_ERROR_CODE.name());
        }
    }

    @Override
    public PersonaResponse actualizar(PersonaRequest personaRequest, Long id) {
        try{
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
            LOGGER.info("La persona {} se actualizó ", personasActualizada);
            return this.entityToResponse(personasActualizada);

        }catch (final Exception exc){
            LOGGER.error(
                    exc.getMessage());

            LOGGER.error(exc);

            throw
                    new ErroresExceptions(
                            INTERNAL_SERVER_ERROR_CODE.name());
        }
    }

    @Override
    public void borrar(Long id) {
        try{
            var borrarPersona = this.personaRepository.findById(id).orElseThrow();
            this.personaRepository.delete(borrarPersona);
            LOGGER.info("La persona {} fue borrada", borrarPersona);

        }catch (final Exception exc){
            LOGGER.error(
                    exc.getMessage());

            LOGGER.error(exc);

            throw
                    new ErroresExceptions(
                            INTERNAL_SERVER_ERROR_CODE.name());
        }

    }
    private PersonaResponse entityToResponse (PersonaEntity entity){
        try{
            var response = new PersonaResponse();
            BeanUtils.copyProperties(entity, response);
            return response;

        }catch (final Exception exc){
            LOGGER.error(
                    exc.getMessage());

            LOGGER.error(exc);

            throw
                    new ErroresExceptions(
                            INTERNAL_SERVER_ERROR_CODE.name());
        }

    }
}
