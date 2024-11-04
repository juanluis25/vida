package com.vida.personas_nuevas.controller;

import com.vida.personas_nuevas.DTO.PersonaDTO;
import com.vida.personas_nuevas.entities.PersonaEntity;
import com.vida.personas_nuevas.infraestructure.abstract_services.IPersonaService;
import com.vida.personas_nuevas.models.request.PersonaRequest;
import com.vida.personas_nuevas.models.response.PersonaResponse;
import com.vida.personas_nuevas.repository.PersonaRepository;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/personasnuevas")

@AllArgsConstructor
public class PersonaController {

    private final IPersonaService personaService;

    @CrossOrigin(value = "*")
    @PostMapping
    public ResponseEntity<PersonaResponse> post(@RequestBody PersonaRequest request){
        return ResponseEntity.ok(personaService.crear(request));
    }
    @CrossOrigin(value = "*")
    @GetMapping(path = "{id}")
    public ResponseEntity<PersonaResponse> get(@PathVariable Long id){
        return ResponseEntity.ok(this.personaService.obtener(id));
    }
    @CrossOrigin(value = "*")
    @PutMapping(path = "{id}")
    public ResponseEntity<PersonaResponse> put(@RequestBody PersonaRequest request,@PathVariable Long id){
        return ResponseEntity.ok(this.personaService.actualizar(request, id));
    }
    @CrossOrigin(value = "*")
    @DeleteMapping(path = "{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        this.personaService.borrar(id);
        return ResponseEntity.noContent().build();
    }
}