package com.vida.personas_nuevas.infraestructure.abstract_services;

public interface CrudService <REQUEST, RESPONSE, ID>{
    RESPONSE crear(REQUEST request);
    RESPONSE obtener(ID id);
    RESPONSE actualizar(REQUEST request, ID id);
    void borrar(ID id);

}
