CREATE TABLE primeravez
(
    "id"                    bigserial NOT NULL,
    fecha                   timestamp NOT NULL,
    nombre                  varchar(50) NOT NULL,
    apellidoPaterno         varchar(20) NOT NULL,
    apellidoMaterno         varchar(20) NOT NULL,
    edad                    int NOT NULL,
    telefono                varchar(20) NOT NULL,
    estadoCivil             varchar(12) NOT NULL,
    comoSupisteDeIglesia    varchar(50) NOT NULL,
    colonia                 varchar(50) NOT NULL,
    nombreVoluntario        varchar(50) NOT NULL,
    condicionVisita         varchar(50) NOT NULL,
    grupoPequeñoInteres     varchar(20) NOT NULL
);

CREATE TABLE estadocivil
(
    "id"                    bigserial NOT NULL,
    estadoCivil             varchar(12) NOT NULL
)