CREATE TABLE aula
(
    id_aula character varying(36) NOT NULL,
    tx_name character varying(256),
    tx_description character varying(1024),
    dt_start character varying(256),
    duration character varying(256),
    id_professor character varying(36) NOT NULL,
    departamento character varying(36) NOT NULL,
    CONSTRAINT aula_pkey PRIMARY KEY (id_aula)
);