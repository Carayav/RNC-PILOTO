create database rnc_bd
with owner postgres;
\connect rnc_bd;
 CREATE SCHEMA schema_rnc;

create table schema_rnc.tipo_tratamiento
(
  codigo             integer     not null
    constraint tipo_tratamiento_pkey
    primary key,
  nombre_tratamiento varchar(50) not null
);

alter table schema_rnc.tipo_tratamiento
  owner to postgres;

create unique index tipo_tratamiento_nombre_tratamiento_uindex
  on schema_rnc.tipo_tratamiento (nombre_tratamiento);

create table schema_rnc.genero
(
  codigo integer not null
    constraint genero_pkey
    primary key,
  nombre varchar(50)
);

alter table schema_rnc.genero
  owner to postgres;

create unique index genero_codigo_uindex
  on schema_rnc.genero (codigo);

create unique index genero_nombre_uindex
  on schema_rnc.genero (nombre);

create table schema_rnc.pueblo_originario
(
  codigo integer     not null,
  nombre varchar(50) not null
);

alter table schema_rnc.pueblo_originario
  owner to postgres;

create unique index pueblo_originario_codigo_uindex
  on schema_rnc.pueblo_originario (codigo);

create unique index pueblo_originario_nombre_uindex
  on schema_rnc.pueblo_originario (nombre);

create table schema_rnc.estado_conyugal
(
  codigo integer     not null
    constraint estado_conyugal_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.estado_conyugal
  owner to postgres;

create unique index estado_conyugal_codigo_uindex
  on schema_rnc.estado_conyugal (codigo);

create unique index estado_conyugal_nombre_uindex
  on schema_rnc.estado_conyugal (nombre);

create table schema_rnc.prevision
(
  codigo integer     not null
    constraint prevision_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.prevision
  owner to postgres;

create unique index prevision_codigo_uindex
  on schema_rnc.prevision (codigo);

create unique index prevision_nombre_uindex
  on schema_rnc.prevision (nombre);

create table schema_rnc.beneficiario_fonasa
(
  codigo integer     not null
    constraint beneficiario_fonasa_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.beneficiario_fonasa
  owner to postgres;

create unique index beneficiario_fonasa_codigo_uindex
  on schema_rnc.beneficiario_fonasa (codigo);

create unique index beneficiario_fonasa_nombre_uindex
  on schema_rnc.beneficiario_fonasa (nombre);

create table schema_rnc.tipos_comite
(
  codigo integer     not null
    constraint tipos_comite_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.tipos_comite
  owner to postgres;

create unique index tipos_comite_codigo_uindex
  on schema_rnc.tipos_comite (codigo);

create unique index tipos_comite_nombre_uindex
  on schema_rnc.tipos_comite (nombre);

create table schema_rnc.pais
(
  codigo integer     not null
    constraint continente_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.pais
  owner to postgres;

create unique index continente_nombre_uindex
  on schema_rnc.pais (nombre);

create unique index continente_codigo_uindex
  on schema_rnc.pais (codigo);

create table schema_rnc.religion_culto
(
  codigo integer     not null
    constraint religion_culto_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.religion_culto
  owner to postgres;

create unique index religion_culto_codigo_uindex
  on schema_rnc.religion_culto (codigo);

create unique index religion_culto_nombre_uindex
  on schema_rnc.religion_culto (nombre);

create table schema_rnc."instrucción"
(
  codigo integer     not null
    constraint "instrucción_pkey"
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc."instrucción"
  owner to postgres;

create unique index "instrucción_codigo_uindex"
  on schema_rnc."instrucción" (codigo);

create unique index "instrucción_nombre_uindex"
  on schema_rnc."instrucción" (nombre);

create table schema_rnc.actividad_economica
(
  codigo integer     not null
    constraint actividad_economica_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.actividad_economica
  owner to postgres;

create unique index actividad_economica_codigo_uindex
  on schema_rnc.actividad_economica (codigo);

create unique index actividad_economica_nombre_uindex
  on schema_rnc.actividad_economica (nombre);

create table schema_rnc.ocupacion
(
  codigo integer     not null
    constraint ocupacion_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.ocupacion
  owner to postgres;

create table schema_rnc."Paciente"
(
  id_paciente         integer     not null
    constraint "Paciente_pkey"
    primary key,
  rut                 integer     not null,
  dverificador        varchar(1)  not null,
  nombre              varchar(50) not null,
  apellido1           varchar(30),
  apellido2           varchar(30),
  fecha_nacimiento    date,
  genero              integer
    constraint paciente_genero_fk
    references genero,
  nacionalidad        integer
    constraint paciente_nacionalidad_fk
    references pais,
  pueblo_originario   integer
    constraint paciente_pueblo_fk
    references pueblo_originario (codigo),
  estado_conyugal     integer
    constraint paciente_estado_conyugal_fk
    references estado_conyugal,
  religion            integer
    constraint paciente_religion_fk
    references religion_culto,
  nivel_instruccion   integer
    constraint paciente_instruccion_fk
    references "instrucción",
  ocupacion           integer
    constraint paciente_ocupacion_fk
    references ocupacion,
  actividad_economica integer
    constraint paciente_actividad_fk
    references actividad_economica,
  prevision           integer
    constraint paciente_prevision_fk
    references prevision,
  beneficiario_fonasa integer
    constraint paciente_beneficiario_fk
    references beneficiario_fonasa
);

alter table schema_rnc.Paciente
  owner to postgres;

create table schema_rnc.Documentos
(
  id_documentos integer not null
    constraint Documentos_pkey
    primary key,
  id_paciente   integer not null
    constraint fk_documentos_paciente
    references "Paciente",
  data          jsonb   not null
);

alter table schema_rnc.Documentos
  owner to postgres;

create unique index ocupacion_codigo_uindex
  on schema_rnc.ocupacion (codigo);

create unique index ocupacion_nombre_uindex
  on schema_rnc.ocupacion (nombre);

create table schema_rnc.ecog
(
  codigo integer      not null
    constraint ecog_pkey
    primary key,
  nombre varchar(255) not null
);

alter table schema_rnc.ecog
  owner to postgres;

create table schema_rnc."Diagnostico"
(
  id_diagnostico     integer     not null
    constraint "Diagnostico_pkey"
    primary key,
  tipo_comite        integer     not null
    constraint diagnostico_tipocomite_fk
    references tipos_comite,
  fecha_diagnostico  date        not null,
  fecha_comite       date        not null,
  diagnostico_comite varchar(50),
  diagnostico_cie10  varchar(7)  not null,
  ecog               integer     not null
    constraint diagnostico_ecog_fk
    references ecog,
  tnm                varchar(10) not null,
  estadio            varchar(10) not null,
  id_paciente        integer     not null
    constraint fk_diagnostico_paciente
    references "Paciente"
);

alter table schema_rnc."Diagnostico"
  owner to postgres;

create unique index ecog_codigo_uindex
  on schema_rnc.ecog (codigo);

create unique index ecog_nombre_uindex
  on schema_rnc.ecog (nombre);

create table schema_rnc.intencion_tratamiento
(
  codigo integer     not null
    constraint intencion_tratamiento_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.intencion_tratamiento
  owner to postgres;

create unique index intencion_tratamiento_codigo_uindex
  on schema_rnc.intencion_tratamiento (codigo);

create unique index intencion_tratamiento_nombre_uindex
  on schema_rnc.intencion_tratamiento (nombre);

create table schema_rnc.motivo_presentacion
(
  codigo integer     not null
    constraint motivo_presentacion_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.motivo_presentacion
  owner to postgres;

create table schema_rnc."Antecedentes"
(
  id_antecedentes        integer not null
    constraint "Antecedentes_pkey"
    primary key,
  fecha_primera_consulta date    not null,
  motivo_presentacion    integer
    constraint antecedentes_motivo_fk
    references motivo_presentacion,
  diagnostico_previo     varchar(255),
  id_diagnostico         integer not null
    constraint fk_antecedentes_diagnostico
    references "Diagnostico"
);

alter table schema_rnc."Antecedentes"
  owner to postgres;

create unique index motivo_presentacion_codigo_uindex
  on schema_rnc.motivo_presentacion (codigo);

create unique index motivo_presentacion_nombre_uindex
  on schema_rnc.motivo_presentacion (nombre);

create table schema_rnc.servicio_salud
(
  codigo integer     not null
    constraint servicio_salud_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.servicio_salud
  owner to postgres;

create table schema_rnc."Establecimiento"
(
  id_establecimiento     integer      not null
    constraint "Establecimiento_pkey"
    primary key,
  servicio_salud         integer      not null
    constraint establecimiento_servicio_fk
    references servicio_salud,
  codigo_establecimiento integer      not null,
  nombre_establecimiento varchar(150) not null,
  id_paciente            integer      not null
    constraint fk_establecimiento_paciente
    references "Paciente"
);

alter table schema_rnc."Establecimiento"
  owner to postgres;

create table schema_rnc."Medico"
(
  id_medico          integer     not null
    constraint "Medico_pkey"
    primary key,
  nombre_medico      varchar(50) not null,
  apellido1          varchar(30),
  apellido2          varchar(30),
  id_establecimiento integer     not null
    constraint fk_medico_establecimiento
    references "Establecimiento"
);

alter table schema_rnc."Medico"
  owner to postgres;

create unique index servicio_salud_codigo_uindex
  on schema_rnc.servicio_salud (codigo);

create unique index servicio_salud_nombre_uindex
  on schema_rnc.servicio_salud (nombre);

create table schema_rnc.region
(
  codigo integer     not null
    constraint region_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.region
  owner to postgres;

create unique index region_codigo_uindex
  on schema_rnc.region (codigo);

create unique index region_nombre_uindex
  on schema_rnc.region (nombre);

create table schema_rnc.provincia
(
  codigo integer     not null
    constraint provincia_pk
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.provincia
  owner to postgres;

create unique index provincia_codigo_uindex
  on schema_rnc.provincia (codigo);

create unique index provincia_nombre_uindex
  on schema_rnc.provincia (nombre);

create table schema_rnc.comuna
(
  codigo integer     not null
    constraint comuna_pkey
    primary key,
  nombre varchar(50) not null
);

alter table schema_rnc.comuna
  owner to postgres;

create table schema_rnc."Localizacion"
(
  id_localizacion    integer     not null
    constraint "Localizacion_pkey"
    primary key,
  region             integer     not null
    constraint localizacion_region_fk
    references region,
  provincia          integer     not null
    constraint localizacion_provincia_fk
    references provincia,
  comuna             integer     not null
    constraint localizacion_comuna_fk
    references comuna,
  direccion          varchar(50) not null,
  id_paciente        integer     not null
    constraint fk_localizacion_paciente
    references "Paciente",
  id_establecimiento integer     not null
    constraint fk_localizacion_establecimiento
    references "Establecimiento"
);

alter table schema_rnc."Localizacion"
  owner to postgres;

create unique index comuna_codigo_uindex
  on schema_rnc.comuna (codigo);

create unique index comuna_nombre_uindex
  on schema_rnc.comuna (nombre);

create table schema_rnc.resolucion_comite
(
  codigo_resolucion integer not null
    constraint resolucion_comite_pkey
    primary key,
  codigo_comite     integer not null
    constraint resolucion_comite_tipo_comite_fk
    references tipos_comite,
  descripcion       text
);

alter table schema_rnc.resolucion_comite
  owner to postgres;

create table schema_rnc."Tratamiento"
(
  id_tratamiento          integer not null
    constraint "Tratamiento_pkey"
    primary key,
  resolucion_comite       integer not null
    constraint tratamiento_resolucion_fk
    references resolucion_comite,
  tipo_tratamiento        integer not null
    constraint tratamiento_tipo_tratamiento_codigo_fk
    references tipo_tratamiento,
  intencion_tratamiento   integer not null
    constraint tratamiento_intencion_codigo_fk
    references intencion_tratamiento,
  fecha_intencion         date    not null,
  descripcion_tratamiento varchar(150),
  id_medico               integer not null
    constraint fk_tratamiento_medico
    references "Medico",
  id_diagnostico          integer not null
    constraint fk_tratamiento_diagnostico
    references "Diagnostico"
);

alter table schema_rnc."Tratamiento"
  owner to postgres;

create unique index resolucion_comite_codigo_resolucion_uindex
  on schema_rnc.resolucion_comite (codigo_resolucion);


