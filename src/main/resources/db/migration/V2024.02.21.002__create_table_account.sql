CREATE TABLE aula
(
    id_aula character varying(36) NOT NULL,
    tx_name character varying(256) NOT NULL,
    tx_description character varying(1024) NOT NULL,
    dt_start timestamp without time zone NOT NULL,
    duration integer NOT NULL,
    id_professor character varying(36) NOT NULL,
    CONSTRAINT aula_pkey PRIMARY KEY (id_aula)
);