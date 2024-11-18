package com.vida.personas_nuevas.controller;

import com.vida.personas_nuevas.infraestructure.abstract_services.IPersonaService;
import com.vida.personas_nuevas.infraestructure.util.SortType;
import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.GrupoResponse;
import com.vida.personas_nuevas.models.response.PersonaResponse;

import lombok.AllArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

import static org.apache.logging.log4j.LogManager.getLogger;

@RestController
@RequestMapping(path = "api/v1/personasnuevas")

@AllArgsConstructor
public class PersonaController {

    private static final Logger LOGGER = getLogger(PersonaController.class);
    private final IPersonaService personaService;
    /**
     * Método que obtiene el <strong>listado de personas que existen</strong>.
     *
     * @return Instancia de {@link ResponseEntity} con la respuesta de la consulta.
     */
    @GetMapping
    public ResponseEntity<Page<PersonaResponse>> getAll(
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestHeader(required = false) SortType sortType) {
        if (Objects.isNull(sortType)) sortType = SortType.NINGUNO;
        var response = this.personaService.readAll(page, size, sortType);
        return response.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(response);
    }
    @PostMapping
    public ResponseEntity<PersonaResponse> post(@RequestBody PersonaRequest request){
        return ResponseEntity.ok(personaService.crear(request));
    }
    @GetMapping(path = "{id}")
    public ResponseEntity<PersonaResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.personaService.obtener(id));
    }
    @PutMapping(path = "{id}")
    public ResponseEntity<PersonaResponse> put(@RequestBody PersonaRequest request,@PathVariable Long id){
        return ResponseEntity.ok(this.personaService.actualizar(request, id));
    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.personaService.borrar(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping(path = "grupo")
    public ResponseEntity<Set<GrupoResponse>> getGrupo(){
        var grupo = this.personaService.categoriaGrupoPorEdades();
        return ResponseEntity.ok(grupo);
    }
}