CREATE DATABASE Gestion_Taller;

USE Gestion_Taller;

CREATE TABLE usuarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE,
    contrasena VARCHAR(50) NOT NULL,
    rol ENUM('PROFESOR','ADMINISTRADOR')
);

CREATE TABLE categorias (
    id_categoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE subcategorias (
    id_subcategoria INT AUTO_INCREMENT PRIMARY KEY,
    id_categoria INT,
    nombre VARCHAR(50) NOT NULL,
    FOREIGN KEY (id_categoria) REFERENCES categorias(id_categoria) ON DELETE CASCADE
);

CREATE TABLE estado (
    id_estado INT AUTO_INCREMENT PRIMARY KEY,
    nombre ENUM('Operativo','Averiado', 'En reparacion', 'Obsoleto')
);

CREATE TABLE ubicaciones (
    id_ubicacion INT AUTO_INCREMENT PRIMARY KEY,
    codigo_armario VARCHAR(10) NOT NULL,
    balda VARCHAR(10) NOT NULL,
    UNIQUE(codigo_armario, balda)
);

CREATE TABLE material (
    id_material INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(300),
    categoria VARCHAR(100),
    subcategoria VARCHAR(100),
    estado VARCHAR(100),
    cantidad INT NOT NULL DEFAULT 0,
    id_ubicacion INT,
    fecha_alta DATE,
    observaciones VARCHAR(300),
    
    FOREIGN KEY (categoria) REFERENCES categorias(nombre),
    FOREIGN KEY (subcategoria) REFERENCES subcategorias(nombre),
    FOREIGN KEY (estado) REFERENCES estado(nombre),
    FOREIGN KEY (id_ubicacion) REFERENCES ubicaciones(id_ubicacion)
);



INSERT INTO estado (nombre) VALUES 
('Operativo'), ('Averiado'), ('En reparacion'), ('Obsoleto');






