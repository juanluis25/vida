package com.vida.personas_nuevas.excepciones;

/**
 * Lista de los códigos de manejo de errores.
 */
public enum ErrorCodes {

    NULL(""),

    BAD_REQUEST_CODE("Solicitud incorrecta"),

    NOT_FOUND_CODE("Usuario no encontrado"),

    UNAUTHORIZED_CODE("Usuario no autorizado"),

    INTERNAL_SERVER_ERROR_CODE("Ha ocurrido un error al procesar la petición"),

    SERVICE_UNAVAILABLE_CODE("Servicio no disponible");



    private String message;

    private ErrorCodes(final String message) {

        this.message = message;

    }

    public String message() {

        return message;

    }

}