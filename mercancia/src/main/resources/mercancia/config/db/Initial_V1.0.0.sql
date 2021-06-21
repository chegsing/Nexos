CREATE DATABASE nexos
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'Spanish_Spain.1252'
    LC_CTYPE = 'Spanish_Spain.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;
    

create table producto(
nombre_producto varchar (80) not null,
cantidad int not null,
fecha_ingreso timestamp not null,
descripcion varchar(250) not null,
CONSTRAINT pk_producto PRIMARY KEY (nombre_producto) );

create table usuario(
identificacion varchar(11) not null,
nombre varchar(80) not null,
apellido varchar(80) not null,
fecha_nacimiento timestamp not null,
fecha_ingreso timestamp not null,
CONSTRAINT pk_usuario PRIMARY KEY (identificacion)
);

create table usuario_producto (
identificacion varchar(11) not null,
nombre_producto varchar (80) not null,
fecha_modificacion timestamp not null,
CONSTRAINT pk_usuario_producto PRIMARY KEY (identificacion, nombre_producto),
CONSTRAINT fk_usuario FOREIGN KEY (identificacion) REFERENCES usuario (identificacion),
CONSTRAINT fk_producto FOREIGN KEY (nombre_producto) REFERENCES producto (nombre_producto)
);

create table cargo(
codigo_cargo varchar(10) not null,
nombre_cargo varchar(50) not null,
descripcion_cargo varchar(250) not null,
CONSTRAINT pk_cargo PRIMARY KEY (codigo_cargo)
);

create table usuario_cargo(
identificacion varchar(11) not null,
codigo_cargo varchar(10) not null,
CONSTRAINT pk_usuario_cargo PRIMARY KEY(identificacion, codigo_cargo),
CONSTRAINT fk_usuario FOREIGN KEY (identificacion) REFERENCES usuario (identificacion),
CONSTRAINT fk_cargo FOREIGN KEY (codigo_cargo) REFERENCES cargo (codigo_cargo)
);