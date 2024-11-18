package com.vida.personas_nuevas.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "primeravezprueba")
@Builder
public class PersonaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private int edad;
    private String telefono;
    private String estadocivil;
    private String comosupistedeiglesia;
    private String colonia;
    private String nombrevoluntario;
    private String condicionvisita;
    private String grupopequeñointeres;
}