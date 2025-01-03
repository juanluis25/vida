package com.vida.personas_nuevas.infraestructure.abstract_services;

import com.vida.personas_nuevas.models.response.PersonaResponse;

public interface CrudService <REQUEST, RESPONSE, ID>{
    /**
     * Inserta todos los datos requeridos.
     *
     * @return {@link PersonaResponse} con los registros insertados.
     */
    RESPONSE crear(REQUEST request);
    /**
     * Consulta todos los datos registrados.
     *
     * @return {@link PersonaResponse} con la consulta de registros.
     */
    RESPONSE obtener(ID id);
    /**
     * Actualiza los datos registrados.
     *
     * @return {@link PersonaResponse} con los registros actualizados.
     */
    RESPONSE actualizar(REQUEST request, ID id);
    /**
     * Borra los datos registrados.
     *
     * @return {@link Void} con el status que el borrado fue exitoso.
     */
    void borrar(ID id);

}