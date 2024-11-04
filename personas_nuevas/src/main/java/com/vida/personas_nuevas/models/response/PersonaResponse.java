package com.vida.personas_nuevas.models.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PersonaResponse implements Serializable {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fecha;
    private String nombre;
    private String apellidopaterno;
    private String apellidomaterno;
    private Integer edad;
    private String telefono;
    private String estadocivil;
    private String comosupistedeiglesia;
    private String colonia;
    private String nombrevoluntario;
    private String condicionvisita;
    private String grupopequeñointeres;
}
