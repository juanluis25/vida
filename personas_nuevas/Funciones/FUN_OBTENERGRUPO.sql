CREATE OR REPLACE FUNCTION fun_obtenergrupo()
RETURNS TABLE(nombre VARCHAR, grupopequeñointeres VARCHAR) AS
$$
BEGIN
    RETURN QUERY
    SELECT primeravezprueba.nombre,
           CASE 
               WHEN edad >= 13 AND edad <= 15 THEN 'Teen'
               WHEN edad >= 16 AND edad <= 20 THEN 'Youth'
               WHEN edad >= 21 AND edad <= 60 THEN 'Pro'
               ELSE 'No entra en categorías'
           END::VARCHAR
    FROM primeravezprueba;
END;
$$ LANGUAGE plpgsql;