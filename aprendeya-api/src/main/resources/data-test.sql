-- Insertar datos en la tabla metodo_ensenanza
INSERT INTO metodo_ensenanza (nombre_metodo, descripcion) VALUES
                                                              ('Método Socrático', 'Método basado en el diálogo y la discusión.'),
                                                              ('Método de Aprendizaje Basado en Problemas', 'Método centrado en la resolución de problemas.'),
                                                              ('Método de Enseñanza A', 'Descripción del Método A'),
                                                              ('Método de Enseñanza B', 'Descripción del Método B');

-- Insertar datos en la tabla cursos
INSERT INTO cursos (nombre_curso, descripcion) VALUES
                                                   ('Matemáticas Básicas', 'Curso introductorio a las matemáticas.'),
                                                   ('Programación en Java', 'Curso para aprender a programar en Java.'),
                                                   ('Curso de Matemáticas', 'Curso básico de matemáticas para estudiantes de secundaria'),
                                                   ('Curso de Ciencias', 'Curso de ciencias naturales para estudiantes de primaria');

-- Insertar datos en la tabla usuarios
INSERT INTO usuarios (nombre, apellido, email, contrasena) VALUES
                                                               ('Juan', 'Pérez', 'juan.perez@example.com', 'password123'),
                                                               ('Ana', 'Gómez', 'ana.gomez@example.com', 'password123'),
                                                               ('Luis', 'Martínez', 'luis.martinez@example.com', 'password123'),
                                                               ('María', 'Fernández', 'maria.fernandez@example.com', 'password123');

-- Insertar datos en la tabla tutores
INSERT INTO tutores (id_usuario, especialidad, experiencia, tarifa_base) VALUES
                                                                             (1, 'Matemáticas', 5, 50.00),
                                                                             (2, 'Programación', 3, 60.00),
                                                                             (3, 'Matemáticas', 5, 50.00),
                                                                             (4, 'Ciencias', 8, 60.00);

-- Insertar datos en la tabla alumnos
INSERT INTO alumnos (id_usuario, grado, descripcion) VALUES
                                                         (2, '10mo Grado', 'Alumno de secundaria interesado en matemáticas.'),
                                                         (3, '9no Grado', 'Alumno de secundaria interesado en programación.'),
                                                         (1, '10º grado', 'Alumno de secundaria.'),
                                                         (4, '9º grado', 'Alumno de secundaria.');

-- Insertar datos en la tabla pagos
INSERT INTO pagos (id_alumno, id_tutor, monto, estado, fecha_pago) VALUES
                                                                       (1, 1, 200.00, 'COMPLETADO', '2024-09-15'),
                                                                       (2, 2, 180.00, 'PENDIENTE', '2024-09-16'),
                                                                       (3, 3, 100.00, 'COMPLETADO', '2024-09-15'),
                                                                       (4, 4, 120.00, 'PENDIENTE', '2024-09-16');

-- Insertar datos en la tabla inscripciones
INSERT INTO inscripciones (id_curso, id_alumno, id_tutor, id_pago, fecha_inscripcion, estado_inscripcion) VALUES
                                                                                                              (1, 1, 1, 1, '2024-09-01', 'CONFIRMADA'),
                                                                                                              (2, 2, 2, 2, '2024-09-02', 'RESERVADA'),
                                                                                                              (3, 3, 3, 3, '2024-09-03', 'CONFIRMADA'),
                                                                                                              (4, 4, 4, 4, '2024-09-04', 'RESERVADA');

-- Insertar datos en la tabla sesiones
INSERT INTO sesiones (id_curso, id_tutor, id_metodo_ensenanza, fecha_sesion, orden_sesion, tema, tipo_sesion, capacidad) VALUES
                                                                                                                             (1, 1, 1, '2024-09-20 10:00:00', 1, 'Introducción a Álgebra', 'INDIVIDUAL', 10),
                                                                                                                             (2, 2, 2, '2024-09-21 11:00:00', 1, 'Estructuras de Datos en Java', 'GRUPAL', 20),
                                                                                                                             (3, 3, 3, '2024-09-18 10:00:00', 1, 'Álgebra Básica', 'INDIVIDUAL', 1),
                                                                                                                             (4, 4, 4, '2024-09-19 14:00:00', 2, 'Biología General', 'GRUPAL', 5);

-- Insertar datos en la tabla horarios
INSERT INTO horarios (id_tutor, dia_semana, hora_inicio, hora_fin) VALUES
                                                                       (1, 'Lunes', '09:00:00', '12:00:00'),
                                                                       (2, 'Martes', '13:00:00', '16:00:00'),
                                                                       (3, 'Lunes', '09:00:00', '12:00:00'),
                                                                       (4, 'Miércoles', '13:00:00', '16:00:00');

-- Insertar datos en la tabla materiales_educativos
INSERT INTO materialeseducativos (id_sesion, tipo_material, nombre_material, url_material, fecha_subida) VALUES
                                                                                                              (1, 'DOCUMENTO', 'Guía de Álgebra', 'http://example.com/guia-algebra.pdf', '2024-09-10'),
                                                                                                              (2, 'VIDEO', 'Introducción a Estructuras de Datos', 'http://example.com/intro-estructuras.mp4', '2024-09-11'),
                                                                                                              (3, 'DOCUMENTO', 'Notas de Álgebra', 'http://example.com/algebra.pdf', '2024-09-15'),
                                                                                                              (4, 'VIDEO', 'Introducción a la Biología', 'http://example.com/biologia.mp4', '2024-09-16');

-- Insertar datos en la tabla asistencia
INSERT INTO asistencias (id_sesion, id_alumno, fecha, estado) VALUES
                                                                  (1, 1, '2024-09-20', 'PRESENTE'),
                                                                  (2, 2, '2024-09-21', 'AUSENTE'),
                                                                  (3, 3, '2024-09-18', 'PRESENTE'),
                                                                  (4, 4, '2024-09-19', 'AUSENTE');

-- Insertar datos en la tabla evaluaciones
INSERT INTO evaluaciones (id_sesion, id_alumno, calificacion, comentario, fecha_evaluacion) VALUES
                                                                                                (1, 1, 4.5, 'Buen desempeño en la sesión.', '2024-09-20'),
                                                                                                (2, 2, 3.0, 'Necesita mejorar en la comprensión.', '2024-09-21'),
                                                                                                (3, 3, 4.5, 'Buen desempeño en la sesión de álgebra.', '2024-09-19'),
                                                                                                (4, 4, 3.8, 'Faltaron algunas participaciones importantes.', '2024-09-20');

-- Insertar datos en la tabla valoraciones_tutores
INSERT INTO valoracionestutores (id_sesion, id_tutor, id_alumno, calificacion, comentario, fecha_valoracion) VALUES
                                                                                                                  (1, 1, 1, 5, 'Excelente tutoría, muy claro.', '2024-09-21'),
                                                                                                                  (2, 2, 2, 4, 'Buena sesión, aunque se podría mejorar el ritmo.', '2024-09-22'),
                                                                                                                  (3, 3, 3, 5, 'Excelente tutor, muy claro en las explicaciones.', '2024-09-20'),
                                                                                                                  (4, 4, 4, 4, 'Buen tutor, aunque podría mejorar en la dinámica de la clase.', '2024-09-21');

-- Insertar datos en la tabla padres
INSERT INTO padres (id_usuario, id_alumno) VALUES
                                               (3, 1),
                                               (3, 2),
                                               (4, 3),
                                               (4, 4);
