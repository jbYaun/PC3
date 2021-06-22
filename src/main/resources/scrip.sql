CREATE DATABASE pc3;
USE pc3;

CREATE TABLE departamento(
                             codigo_departamento VARCHAR(10)	PRIMARY KEY,
                             nombre_departamento VARCHAR(100),
                             ubicacion_departamento VARCHAR(50)
);

CREATE TABLE actividad(
                          id_actividad NUMERIC(4) PRIMARY KEY,
                          nombre_actividad VARCHAR(50),
                          prioridad NUMERIC(1)
);

CREATE TABLE empleado(
                         codigo_empleado VARCHAR(20) PRIMARY KEY,
                         codigo_departamento VARCHAR(10),
                         nombres_empleados VARCHAR(50),
                         apellidos_empleados VARCHAR(100)
);

CREATE TABLE asignacion(
                           id_asignacion NUMERIC(50) PRIMARY KEY,
                           codigo_empleado VARCHAR(20),
                           id_actividad NUMERIC(4),
                           presupuesto NUMERIC(9,2)
);


ALTER TABLE empleado
    ADD FOREIGN KEY (codigo_departamento) REFERENCES departamento(codigo_departamento);

ALTER TABLE asignacion
    ADD FOREIGN KEY (codigo_empleado) REFERENCES empleado(codigo_empleado),
ADD FOREIGN KEY (id_actividad) REFERENCES actividad(id_actividad);

INSERT INTO departamento VALUES ('1', 'lima', 'peru');
INSERT INTO departamento VALUES ('2', 'arequipa', 'peru');
INSERT INTO departamento VALUES ('3', 'ucayali', 'peru');

INSERT INTO actividad VALUES (1, 'turismo', 3);
INSERT INTO actividad VALUES (2, 'gastronomia', 4);
INSERT INTO actividad VALUES (3, 'fotografia', 5);

INSERT INTO empleado VALUES ('A', '1', 'Jean','Yaun');
INSERT INTO empleado VALUES ('B', '3', 'Erik','Ramirez');
INSERT INTO empleado VALUES ('C', '2', 'Alvaro','Ramos');

INSERT INTO asignacion VALUES (10, 'B', 1, 20);
INSERT INTO asignacion VALUES (20, 'A', 3, 50);
INSERT INTO asignacion VALUES (30, 'C', 2, 70);


SELECT *
FROM empleado;
