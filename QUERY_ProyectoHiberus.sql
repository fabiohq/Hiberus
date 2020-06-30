
CREATE DATABASE "ProyectoHiberus"
  WITH OWNER = postgres
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'es_CO.UTF-8'
       LC_CTYPE = 'es_CO.UTF-8'
       CONNECTION LIMIT = -1;

GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO public;
COMMENT ON SCHEMA public
  IS 'standard public schema';

CREATE TABLE public.consolidado_vendedor
(
  id_consolidado_vendedor integer NOT NULL DEFAULT nextval('consolidado_vendedor_idconsolidadovendedor_seq'::regclass),
  fecha date,
  valor numeric(8,2),
  docvendedor character varying(11),
  CONSTRAINT consolidado_vendedor_pkey PRIMARY KEY (id_consolidado_vendedor)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.consolidado_vendedor
  OWNER TO postgres;


CREATE TABLE public.detalle_pago
(
  id_detalle_pago integer NOT NULL DEFAULT nextval('detalle_pago_id_detalle_pago_seq'::regclass),
  id_consolidado_vendedor integer,
  fecha_pago date,
  valor numeric(8,2),
  referencia character varying(6),
  docvendedor character varying(11),
  doccliente character varying(11),
  nombre_cliente character varying(400),
  consolidado_vendedor_id_consolidado_vendedor integer,
  hora_venta character varying(10),
  CONSTRAINT detalle_pago_pkey PRIMARY KEY (id_detalle_pago),
  CONSTRAINT detalle_pago_id_consolidado_vendedor_fkey FOREIGN KEY (id_consolidado_vendedor)
      REFERENCES public.consolidado_vendedor (id_consolidado_vendedor) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fkij908hl197im2skkans1pwso1 FOREIGN KEY (consolidado_vendedor_id_consolidado_vendedor)
      REFERENCES public.consolidado_vendedor (id_consolidado_vendedor) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.detalle_pago
  OWNER TO postgres;

-- Index: public.i_consolidado_vendedor

-- DROP INDEX public.i_consolidado_vendedor;

CREATE INDEX i_consolidado_vendedor
  ON public.detalle_pago
  USING btree
  (id_consolidado_vendedor);


CREATE TABLE public.pago_pendiente
(
  id_pago_pendiente integer NOT NULL DEFAULT nextval('pago_pendiente_id_pago_pendiente_seq'::regclass),
  id_detalle_pago integer,
  valor numeric(8,2),
  referencia character varying(19),
  fecha_limite_pago date,
  documento character varying(11),
  nombre1 character varying(100),
  nombre2 character varying(100),
  apellido1 character varying(100),
  apellido2 character varying(100),
  detalle_pago_id_detalle_pago integer,
  CONSTRAINT pago_pendiente_pkey PRIMARY KEY (id_pago_pendiente),
  CONSTRAINT fkf66g03kxltwic8nsrvp6fvcv7 FOREIGN KEY (detalle_pago_id_detalle_pago)
      REFERENCES public.detalle_pago (id_detalle_pago) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT pago_pendiente_id_detalle_pago_fkey FOREIGN KEY (id_detalle_pago)
      REFERENCES public.detalle_pago (id_detalle_pago) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.pago_pendiente
  OWNER TO postgres;

-- Index: public.i_pago_pendiente

-- DROP INDEX public.i_pago_pendiente;

CREATE INDEX i_pago_pendiente
  ON public.pago_pendiente
  USING btree
  (id_detalle_pago);


--SECUENCIAS
CREATE SEQUENCE public.consolidado_vendedor_idconsolidadovendedor_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 18
  CACHE 1;
ALTER TABLE public.consolidado_vendedor_idconsolidadovendedor_seq
  OWNER TO postgres;

CREATE SEQUENCE public.detalle_pago_id_detalle_pago_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 55
  CACHE 1;
ALTER TABLE public.detalle_pago_id_detalle_pago_seq
  OWNER TO postgres;

CREATE SEQUENCE public.pago_pendiente_id_pago_pendiente_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE public.pago_pendiente_id_pago_pendiente_seq
  OWNER TO postgres;



