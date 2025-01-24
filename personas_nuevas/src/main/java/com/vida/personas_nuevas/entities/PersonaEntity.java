package com.vida.personas_nuevas.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm")
    @Column(name = "fecha", nullable = false)
    private LocalDateTime fecha;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellidopaterno", nullable = false)
    private String apellidopaterno;
    @Column(name = "apellidomaterno", nullable = false)
    private String apellidomaterno;
    @Column(name = "edad", nullable = false)
    private int edad;
    @Column(name = "telefono", nullable = false)
    private String telefono;
    @Column(name = "estadocivil", nullable = false)
    private String estadocivil;
    @Column(name = "comosupistedeiglesia", nullable = false)
    private String comosupistedeiglesia;
    @Column(name = "colonia", nullable = false)
    private String colonia;
    @Column(name = "nombrevoluntario", nullable = false)
    private String nombrevoluntario;
    @Column(name = "condicionvisita", nullable = false)
    private String condicionvisita;
    @Column(name = "grupopequeñointeres", nullable = false)
    private String grupopequeñointeres;
    @Column(name = "oraciondefe", nullable = false)
    private Boolean oraciondefe;
}