package com.vida.personas_nuevas.infraestructure.service.impl;

import static com.vida.personas_nuevas.excepciones.ErrorCodes.INTERNAL_SERVER_ERROR_CODE;

import com.vida.personas_nuevas.excepciones.ErroresExceptions;
import com.vida.personas_nuevas.entities.PersonaEntity;
import com.vida.personas_nuevas.infraestructure.abstract_services.IPersonaService;
import com.vida.personas_nuevas.infraestructure.util.SortType;
import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.PersonaResponse;
import com.vida.personas_nuevas.repository.PersonaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static com.vida.personas_nuevas.infraestructure.abstract_services.CatalogService.ORDENADO_POR_FECHA;
import static com.vida.personas_nuevas.infraestructure.abstract_services.CatalogService.ORDENADO_POR_NOMBRE;
import static org.apache.logging.log4j.LogManager.getLogger;


@Transactional
@Service
@Slf4j
@AllArgsConstructor
public class PersonaService implements IPersonaService {

    private static final Logger LOGGER = getLogger(PersonaService.class);
    private final PersonaRepository personaRepository;

    @Override
    public Page<PersonaResponse> readAll(Integer page, Integer size, SortType sortType) {
        PageRequest pageRequest = null;
        switch (sortType) {
            case NINGUNO -> pageRequest = PageRequest.of(page, size);
            case ASCENDENTE -> pageRequest = PageRequest.of(page, size, Sort.by(ORDENADO_POR_NOMBRE).ascending());
            case DESCENDENTE -> pageRequest = PageRequest.of(page, size, Sort.by(ORDENADO_POR_FECHA).descending());
        }
        return this.personaRepository.findAll(pageRequest).map(this::entityToResponse);
    }

    @Override
    public Set<PersonaResponse> findAll(){
        try {
            List<PersonaEntity> obtenerPersonas = this.personaRepository.findAll();
            return obtenerPersonas.stream()
                    .map(this::entityToResponse)
                    .collect(Collectors.toSet());
        } catch (final Exception exc) {
            LOGGER.error(exc.getMessage());
            LOGGER.error(exc);
            throw new ErroresExceptions(INTERNAL_SERVER_ERROR_CODE.name());
        }
    }

    @Override
    public Optional<List<PersonaEntity>> filtrarPersonas(String nombre, String apellidopaterno, String apellidomaterno, String telefono){

        if (nombre != null){
            LOGGER.info("Nombre: {}", nombre);
            return personaRepository.findByNombre(nombre);
        }
        if (apellidopaterno != null){
            LOGGER.info("Apellido Paterno: {}", apellidopaterno);
            return personaRepository.findByApellidopaterno(apellidopaterno);
        }
        if (apellidomaterno != null){
            LOGGER.info("Apellido Materno: {}", apellidomaterno);
            return personaRepository.findByApellidomaterno(apellidomaterno);
        }
        if (telefono != null){
            LOGGER.info("Telefono: {}", telefono);
            return personaRepository.findByTelefono(telefono);
        }
       return Optional.of((personaRepository.findAll()));
      }

    @Override
    public PersonaResponse crear(PersonaRequest personaRequest) {
        try {
            var registrarPersona = PersonaEntity.builder()
                    .fecha(LocalDateTime.now())
                    .nombre(personaRequest.getNombre())
                    .apellidopaterno(personaRequest.getApellidopaterno())
                    .apellidomaterno(personaRequest.getApellidomaterno())
                    .edad(personaRequest.getEdad())
                    .telefono(personaRequest.getTelefono())
                    .estadocivil(personaRequest.getEstadocivil())
                    .comosupistedeiglesia(personaRequest.getComosupistedeiglesia())
                    .colonia(personaRequest.getColonia())
                    .nombrevoluntario(personaRequest.getNombrevoluntario())
                    .condicionvisita(personaRequest.getCondicionvisita())
                    .grupopequeñointeres(personaRequest.getGrupopequeñointeres())
                    .oraciondefe(personaRequest.getOraciondefe())
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
            actualizarPersona.setApellidopaterno(personaRequest.getApellidopaterno());
            actualizarPersona.setApellidomaterno(personaRequest.getApellidomaterno());
            actualizarPersona.setEdad(personaRequest.getEdad());
            actualizarPersona.setEstadocivil(personaRequest.getEstadocivil());
            actualizarPersona.setTelefono(personaRequest.getTelefono());
            actualizarPersona.setComosupistedeiglesia(personaRequest.getComosupistedeiglesia());
            actualizarPersona.setColonia(personaRequest.getColonia());
            actualizarPersona.setNombrevoluntario(personaRequest.getNombrevoluntario());
            actualizarPersona.setCondicionvisita(personaRequest.getCondicionvisita());
            actualizarPersona.setGrupopequeñointeres(personaRequest.getGrupopequeñointeres());
            actualizarPersona.setOraciondefe(personaRequest.getOraciondefe());

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
