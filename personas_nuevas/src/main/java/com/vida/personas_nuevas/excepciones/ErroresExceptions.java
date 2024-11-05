package com.vida.personas_nuevas.excepciones;

/**
 * Custom {@link RuntimeException}.
 */
public class ErroresExceptions extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * {@inheritDoc}
     */
    public ErroresExceptions(String mensaje) {

        super(mensaje);

    }

}