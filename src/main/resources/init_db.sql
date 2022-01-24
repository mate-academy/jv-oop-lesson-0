CREATE DATABASE "client-service"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8';

CREATE TABLE public.clients
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    created timestamp without time zone NOT NULL,
    deleted timestamp without time zone,
    is_deleted boolean NOT NULL DEFAULT false,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.clients
    OWNER to postgres;

CREATE TABLE public.personal_info
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    client_id bigint NOT NULL,
    full_name character varying(255) NOT NULL,
    passport character varying(255),
    date_of_birth date,
    created timestamp without time zone NOT NULL,
    deleted timestamp without time zone,
    is_deleted boolean NOT NULL DEFAULT false,
    PRIMARY KEY (id),
    CONSTRAINT client_id FOREIGN KEY (client_id)
        REFERENCES public.clients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT DEFERRABLE
);

ALTER TABLE IF EXISTS public.personal_info
    OWNER to postgres;

CREATE TABLE public.phone_number_types
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    type character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE IF EXISTS public.phone_number_types
    OWNER to postgres;

CREATE TABLE public.phone_numbers
(
    id bigint NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    client_id bigint NOT NULL,
    phone_number character varying(255) NOT NULL,
    phone_number_type_id bigint NOT NULL,
    created timestamp without time zone NOT NULL,
    deleted timestamp without time zone,
    is_deleted boolean NOT NULL DEFAULT false,
    PRIMARY KEY (id),
    CONSTRAINT client_id FOREIGN KEY (client_id)
        REFERENCES public.clients (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT DEFERRABLE,
    CONSTRAINT phone_number_type_id FOREIGN KEY (phone_number_type_id)
        REFERENCES public.phone_number_types (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT DEFERRABLE
);

ALTER TABLE IF EXISTS public.phone_numbers
    OWNER to postgres;

ALTER TABLE IF EXISTS public.phone_numbers
    ADD CONSTRAINT unique_phone_number UNIQUE (phone_number);

INSERT INTO phone_number_types (type) VALUES ('Main');
INSERT INTO phone_number_types (type) VALUES ('Additional');
