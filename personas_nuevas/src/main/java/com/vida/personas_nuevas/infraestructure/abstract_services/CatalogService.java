package com.vida.personas_nuevas.infraestructure.abstract_services;

import com.vida.personas_nuevas.infraestructure.util.SortType;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.util.Set;

public interface CatalogService <R>{
    Page<R> readAll(Integer page, Integer size, SortType sortType);
    Set<R> readLessPrice(BigDecimal price);
    Set<R> readBetweenPrice(BigDecimal min, BigDecimal max);

    String ORDENADO_POR_FECHA = "fecha";
    String ORDENADO_POR_NOMBRE = "nombre";
}
