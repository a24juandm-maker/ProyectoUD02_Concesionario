DROP DATABASE Proxecto02;
CREATE DATABASE IF NOT EXISTS Proxecto02;
USE Proxecto02;

-- =========================
-- TABLAS
-- =========================

CREATE TABLE FABRICA(
	id_fabrica INT NOT NULL,
	nombre VARCHAR(30),
	direccion VARCHAR(50),
	ciudad VARCHAR(25),
	pais VARCHAR(15),
	PRIMARY KEY (id_fabrica)
);

CREATE TABLE COCHE(
	id_coche INT NOT NULL,
	matricula VARCHAR(7) UNIQUE NOT NULL,
	color VARCHAR(10),
	anho INT,
	modelo VARCHAR(20),
	id_fabricacion INT,
	disponibilidad BOOLEAN,
	precio FLOAT,
	imagen VARCHAR(255),
	PRIMARY KEY (id_coche)
);

CREATE TABLE EMPLEADO(
	id_empleado INT NOT NULL AUTO_INCREMENT,
	NIF VARCHAR(9) UNIQUE NOT NULL,
	nombre VARCHAR(70) NOT NULL,
	usuario VARCHAR(15) UNIQUE,
	contrasenha VARCHAR(255),
	salario FLOAT,
	mail VARCHAR(50),
	telefono VARCHAR(12),
	puesto VARCHAR(20),
	direccion VARCHAR(50),
	PRIMARY KEY (id_empleado)
);

CREATE TABLE CLIENTE(
	id_cliente INT NOT NULL,
	NIF VARCHAR(9) NOT NULL,
	nombre VARCHAR(70) NOT NULL,
	telefono VARCHAR(12),
	mail VARCHAR(50),
	PRIMARY KEY (id_cliente)
);

CREATE TABLE ALQUILA(
	id_alquiler INT NOT NULL AUTO_INCREMENT,
	fecha_alquiler DATE,
	fecha_devolucion DATE,
	id_coche INT,
	id_cliente INT,
	id_empleado INT,
	PRIMARY KEY (id_alquiler)
);

CREATE TABLE VENTA(
	id_venta INT NOT NULL AUTO_INCREMENT,
	fecha_venta DATE,
	id_coche INT,
	id_cliente INT,
	id_empleado INT,
	PRIMARY KEY (id_venta)
);

-- =========================
-- CLAVES FORÁNEAS
-- =========================

ALTER TABLE COCHE
ADD CONSTRAINT K_COCHE_FABRICA
FOREIGN KEY (id_fabricacion)
REFERENCES FABRICA(id_fabrica)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE VENTA
ADD CONSTRAINT K_VENTA_COCHE
FOREIGN KEY (id_coche)
REFERENCES COCHE(id_coche)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE VENTA
ADD CONSTRAINT K_VENTA_CLIENTE
FOREIGN KEY (id_cliente)
REFERENCES CLIENTE(id_cliente)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE VENTA
ADD CONSTRAINT K_VENTA_TRABAJADOR
FOREIGN KEY (id_empleado)
REFERENCES EMPLEADO(id_empleado)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ALQUILA
ADD CONSTRAINT K_ALQUILA_COCHE
FOREIGN KEY (id_coche)
REFERENCES COCHE(id_coche)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ALQUILA
ADD CONSTRAINT K_ALQUILA_CLIENTE
FOREIGN KEY (id_cliente)
REFERENCES CLIENTE(id_cliente)
ON UPDATE CASCADE ON DELETE RESTRICT;

ALTER TABLE ALQUILA
ADD CONSTRAINT K_ALQUILA_TRABAJADOR
FOREIGN KEY (id_empleado)
REFERENCES EMPLEADO(id_empleado)
ON UPDATE CASCADE ON DELETE RESTRICT;

-- =========================
-- DATOS
-- =========================

-- FABRICAS BMW
INSERT INTO FABRICA VALUES
(1, 'BMW Munich', 'Petuelring 130', 'Munich', 'Alemania'),
(2, 'BMW Leipzig', 'BMW Allee 1', 'Leipzig', 'Alemania'),
(3, 'BMW Dingolfing', 'Dr.-Wilhelm-Mayr-Str. 1', 'Dingolfing', 'Alemania'),
(4, 'BMW Spartanburg', 'Highway 101', 'Spartanburg', 'USA');

-- EMPLEADO (único)
INSERT INTO EMPLEADO
(NIF, nombre, usuario, contrasenha, salario, mail, telefono, puesto, direccion)
VALUES
('12345678A', 'Empleado BMW', 'usuario', 'abc123', 2500, 'empleado@bmw.com', '600123123', 'Vendedor', 'Calle Central 10');

-- CLIENTES
INSERT INTO CLIENTE VALUES
(1, '11111111A', 'Carlos Gómez', '600111111', 'carlos@gmail.com'),
(2, '22222222B', 'Ana López', '600222222', 'ana@gmail.com'),
(3, '33333333C', 'Luis Pérez', '600333333', 'luis@gmail.com'),
(4, '44444444D', 'María Torres', '600444444', 'maria@gmail.com'),
(5, '55555555E', 'Javier Martín', '600555555', 'javier@gmail.com'),
(6, '66666666F', 'Laura Sánchez', '600666666', 'laura@gmail.com');

-- COCHES BMW
INSERT INTO COCHE VALUES
(1, '1234ABC', 'Negro', 2022, 'BMW Serie 3', 1, TRUE, 38000, 'serie3.jpg'),
(2, '2345BCD', 'Blanco', 2021, 'BMW Serie 5', 1, TRUE, 52000, 'serie5.jpg'),
(3, '3456CDE', 'Azul', 2020, 'BMW X1', 2, TRUE, 42000, 'x1.jpg'),
(4, '4567DEF', 'Gris', 2023, 'BMW X3', 2, FALSE, 61000, 'x3.jpg'),
(5, '5678EFG', 'Rojo', 2019, 'BMW X5', 3, TRUE, 75000, 'x5.jpg'),
(6, '6789FGH', 'Negro', 2022, 'BMW Serie 1', 3, TRUE, 32000, 'serie1.jpg'),
(7, '7890GHI', 'Blanco', 2021, 'BMW X6', 4, FALSE, 82000, 'x6.jpg'),
(8, '8901HIJ', 'Azul', 2023, 'BMW i4', 1, TRUE, 59000, 'i4.jpg'),
(9, '9012IJK', 'Gris', 2022, 'BMW iX', 4, TRUE, 87000, 'ix.jpg'),
(10,'0123JKL', 'Negro', 2020, 'BMW Z4', 2, TRUE, 68000, 'z4.jpg');

-- ALQUILERES
INSERT INTO ALQUILA
(fecha_alquiler, fecha_devolucion, id_coche, id_cliente, id_empleado)
VALUES
('2024-01-10', '2024-01-15', 1, 1, 1),
('2024-02-05', '2024-02-10', 3, 2, 1),
('2024-03-01', '2024-03-07', 6, 3, 1),
('2024-03-12', '2024-03-20', 8, 4, 1);

-- VENTAS
INSERT INTO VENTA
(fecha_venta, id_coche, id_cliente, id_empleado)
VALUES
('2024-01-20', 4, 5, 1),
('2024-02-18', 7, 6, 1),
('2024-03-25', 2, 1, 1);
