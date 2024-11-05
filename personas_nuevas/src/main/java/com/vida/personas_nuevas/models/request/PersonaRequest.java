package com.vida.personas_nuevas.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaRequest implements Serializable {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Integer edad;
    private String telefono;
    private String estadoCivil;
    private String comoSupisteDeIglesia;
    private String colonia;
    private String nombreVoluntario;
    private String condicionVisita;
    private String grupoPequeñoInteres;
}
