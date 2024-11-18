package com.vida.personas_nuevas.models.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class GrupoResponse {
    private String nombre;
    private String grupopequeñointeres;
}
