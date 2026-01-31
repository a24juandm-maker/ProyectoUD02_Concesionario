DROP database proxecto02;
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
INSERT INTO COCHE (id_coche, matricula, color, anho, modelo, id_fabricacion, disponibilidad, precio, imagen) VALUES
(1,  '1001AAA', 'Negro', 2022, 'BMW Serie 1', 1, TRUE, 32000, 'serie1.jpg'),
(2,  '1002AAB', 'Blanco',2021, 'BMW Serie 2', 1, TRUE, 36000, 'serie2.jpg'),
(3,  '1003AAC', 'Gris',  2023, 'BMW Serie 3', 1, TRUE, 42000, 'serie3.jpg'),
(4,  '1004AAD', 'Azul',  2022, 'BMW Serie 4', 1, TRUE, 48000, 'serie4.jpg'),
(5,  '1005AAE', 'Negro', 2021, 'BMW Serie 5', 1, TRUE, 52000, 'serie5.jpg'),

(6,  '2001BBB', 'Blanco',2022, 'BMW Serie 7', 2, TRUE, 95000, 'serie7.jpg'),
(7,  '2002BBC', 'Gris',  2023, 'BMW X1',      2, TRUE, 41000, 'x1.jpg'),
(8,  '2003BBD', 'Azul',  2021, 'BMW X2',      2, TRUE, 43000, 'x2.jpg'),
(9,  '2004BBE', 'Negro', 2022, 'BMW X3',      2, TRUE, 61000, 'x3.jpg'),
(10, '2005BBF', 'Blanco',2023, 'BMW X4',      2, TRUE, 67000, 'x4.jpg'),

(11, '3001CCC', 'Gris',  2021, 'BMW X5',      3, TRUE, 75000, 'x5.jpg'),
(12, '3002CCD', 'Negro', 2022, 'BMW X6',      3, TRUE, 82000, 'x6.jpg'),
(13, '3003CCE', 'Blanco',2023, 'BMW X7',      3, TRUE, 98000, 'x7.jpg'),
(14, '3004CCF', 'Azul',  2022, 'BMW Z4',      3, TRUE, 68000, 'z4.jpg'),
(15, '3005CCG', 'Rojo',  2021, 'BMW M3',      3, TRUE, 86000, 'm3.jpg'),

(16, '4001DDD', 'Negro', 2023, 'BMW i3',      4, TRUE, 39000, 'i3.jpg'),
(17, '4002DDE', 'Blanco',2022, 'BMW i4',      4, TRUE, 59000, 'i4.jpg'),
(18, '4003DDF', 'Gris',  2023, 'BMW iX',      4, TRUE, 87000, 'ix.jpg'),
(19, '4004DDG', 'Azul',  2022, 'BMW M4',      4, TRUE, 92000, 'm4.jpg'),
(20, '4005DDH', 'Negro', 2021, 'BMW Serie 8', 4, TRUE, 105000,'serie8.jpg');
