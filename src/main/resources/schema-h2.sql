create table usuario (
    id identity primary key,
    nombre varchar(100) not null,
    apellido varchar(100) not null,
     correo varchar(100) not null,
    celular varchar(100) not null,
     clave varchar(100) not null,
);