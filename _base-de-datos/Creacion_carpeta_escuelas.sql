DROP DATABASE test;
CREATE DATABASE test;
USE test;
CREATE TABLE escuelas(
	id_escuela integer NOT NULL,
	nombre_escuela varchar(40) NOT NULL, 
	habilidad_especial_escuela varchar(40) NOT NULL, 
	antiguedad_escuela integer NOT NULL, 
	creador_escuela varchar(20) NOT NULL,
	fecha_inicio_escuela date NOT NULL, 
	PRIMARY KEY(id_escuela)
);
INSERT INTO escuelas(id_escuela, nombre_escuela, habilidad_especial_escuela, antiguedad_escuela, creador_escuela, fecha_inicio_escuela) 
VALUES (232, 'Gauchondor', 'magia pura', 20, 'Ronaldinhus', '2001-12-12'); 
INSERT INTO escuelas(id_escuela, nombre_escuela, habilidad_especial_escuela, antiguedad_escuela, creador_escuela, fecha_inicio_escuela)
VALUES (9865, 'Parmiterin', 'velocidad', 13, 'Asprillini', '2008-02-28');
INSERT INTO escuelas(id_escuela, nombre_escuela, habilidad_especial_escuela, antiguedad_escuela, creador_escuela, fecha_inicio_escuela)
VALUES (22682, 'Riventus', 'precisión', 10, 'Pirlotes', '2011-06-21');

CREATE TABLE pociones(
	id_pocion integer NOT NULL,
	nombre_pocion varchar(30) NOT NULL,
	litros_realizados_pocion decimal(10,2) DEFAULT 0 NOT NULL,
	usos_pocion integer DEFAULT 0 NOT NULL,
	PRIMARY KEY (id_pocion)
);
INSERT INTO pociones(id_pocion, nombre_pocion, litros_realizados_pocion, usos_pocion)
VALUES (12, 'Bomba Antiresaca', 278.8, 400);
INSERT INTO pociones(id_pocion, nombre_pocion)
VALUES (872, 'Borojo con Tarrito Rojo');

CREATE TABLE ingredientes(
	nombre_ingrediente varchar(30) NOT NULL,	
	peso_ingrediente integer DEFAULT 0 NULL,
	existencias_jaguars_ingrediente integer DEFAULT 0 NULL,
	reaccion_ingrediente decimal(3,1) NOT NULL CHECK (reaccion_ingrediente < 10),	
	id_ingrediente integer,
	PRIMARY KEY (nombre_ingrediente) 
);
INSERT INTO ingredientes(nombre_ingrediente, peso_ingrediente, existencias_jaguars_ingrediente, reaccion_ingrediente, id_ingrediente)
VALUES ('Soda', 394, 1, 9.3, 12);
INSERT INTO ingredientes(nombre_ingrediente, peso_ingrediente, existencias_jaguars_ingrediente, reaccion_ingrediente, id_ingrediente)
VALUES ('Borojo', 123, 1, 8.9, 872);
INSERT INTO ingredientes(nombre_ingrediente, reaccion_ingrediente, id_ingrediente)
VALUES ('Tarrito Rojo', 0.1, 872);

CREATE TABLE recetas(
	id_receta integer AUTO_INCREMENT,
	fecha_creacion_receta datetime,
	id_pocion_fk integer,
	id_escuela_fk integer,
	PRIMARY KEY (id_receta),
	FOREIGN KEY(id_pocion_fk) REFERENCES pociones(id_pocion),
	FOREIGN KEY(id_escuela_fk) REFERENCES escuelas(id_escuela)
);
INSERT INTO recetas (fecha_creacion_receta, id_pocion_fk, id_escuela_fk)
VALUES (now(), 12, 232);
INSERT INTO recetas (fecha_creacion_receta, id_pocion_fk, id_escuela_fk)
VALUES ('2019-02-12 18:56:45', 872, 9865);

DELETE FROM escuelas WHERE nombre_escuela='Riventus';
UPDATE pociones
SET litros_realizados_pocion=1240.2, usos_pocion=2334
WHERE nombre_pocion='Borojo con Tarrito Rojo';
UPDATE ingredientes
SET existencias_jaguars_ingrediente='0', reaccion_ingrediente=4.1
WHERE nombre_ingrediente='Tarrito Rojo';
INSERT INTO recetas (fecha_creacion_receta, id_pocion_fk, id_escuela_fk)
VALUES (now(), 872, 9865);

SELECT 'Consulta 1';
SELECT * FROM escuelas;
SELECT 'Consulta 2';
SELECT id_pocion, nombre_pocion, cast(litros_realizados_pocion as decimal(10,2)), usos_pocion, nombre_escuela, habilidad_especial_escuela
FROM pociones, escuelas, recetas 
WHERE (pociones.id_pocion=recetas.id_pocion_fk AND id_escuela=recetas.id_escuela_fk)
GROUP BY id_pocion;
SELECT 'Consulta 3';
SELECT nombre_ingrediente, existencias_jaguars_ingrediente, reaccion_ingrediente, nombre_pocion
FROM ingredientes, pociones, escuelas, recetas
WHERE (ingredientes.id_ingrediente=872)
GROUP BY nombre_ingrediente
ORDER BY nombre_ingrediente;