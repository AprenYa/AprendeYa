-- Inserción en la tabla MetodosEnsenanza
INSERT INTO MetodosEnsenanza (nombre_metodo, descripcion) VALUES
                                                              ('Método de Enseñanza A', 'Descripción del Método A'),
                                                              ('Método de Enseñanza B', 'Descripción del Método B');

-- Inserción en la tabla Cursos
INSERT INTO Cursos (nombre_curso, descripcion) VALUES
                                                   ('Curso de Matemáticas', 'Curso básico de matemáticas para estudiantes de secundaria'),
                                                   ('Curso de Ciencias', 'Curso de ciencias naturales para estudiantes de primaria');

-- Inserción en la tabla Usuarios
INSERT INTO Usuarios (nombre, apellido, email, contraseña, tipo_usuario) VALUES
                                                                             ('Juan', 'Pérez', 'juan.perez@example.com', 'contraseña1', 'alumno'),
                                                                             ('Ana', 'Gómez', 'ana.gomez@example.com', 'contraseña2', 'alumno'),
                                                                             ('Luis', 'Martínez', 'luis.martinez@example.com', 'contraseña3', 'tutor'),
                                                                             ('María', 'Fernández', 'maria.fernandez@example.com', 'contraseña4', 'tutor');

-- Inserción en la tabla Tutores
INSERT INTO Tutores (id_usuario, especialidad, experiencia, tarifa_base) VALUES
                                                                             (3, 'Matemáticas', 5, 50.00),
                                                                             (4, 'Ciencias', 8, 60.00);

-- Inserción en la tabla Alumnos
INSERT INTO Alumnos (id_usuario, grado) VALUES
                                            (1, '10º grado'),
                                            (2, '9º grado');

-- Inserción en la tabla Pagos
INSERT INTO Pagos (id_alumno, id_tutor, monto, estado, fecha_pago) VALUES
                                                                       (1, 1, 100.00, 'Completado', '2024-09-15'),
                                                                       (2, 2, 120.00, 'Pendiente', '2024-09-16');

-- Inserción en la tabla Inscripciones
INSERT INTO Inscripciones (id_curso, id_alumno, id_tutor, id_pago, fecha_inscripcion) VALUES
                                                                                          (1, 1, 1, 1, '2024-09-01'),
                                                                                          (2, 2, 2, 2, '2024-09-02');

-- Inserción en la tabla Sesion
INSERT INTO Sesion (id_curso, id_tutor, id_metodo_ensenanza, fecha_sesion, orden_sesion, tema, tipo_sesion, capacidad) VALUES
                                                                                                                           (1, 1, 1, '2024-09-18 10:00:00', 1, 'Álgebra Básica', 'Individual', 1),
                                                                                                                           (2, 2, 2, '2024-09-19 14:00:00', 2, 'Biología General', 'Grupal', 5);

-- Inserción en la tabla Horarios
INSERT INTO Horarios (id_tutor, dia_semana, hora_inicio, hora_fin) VALUES
                                                                       (1, 'Lunes', '09:00:00', '12:00:00'),
                                                                       (2, 'Miércoles', '13:00:00', '16:00:00');

-- Inserción en la tabla MaterialesEducativos
INSERT INTO MaterialesEducativos (id_sesion, tipo_material, nombre_material, url_material, fecha_subida) VALUES
                                                                                                             (1, 'Documento', 'Notas de Álgebra', 'http://example.com/algebra.pdf', '2024-09-15'),
                                                                                                             (2, 'Video', 'Introducción a la Biología', 'http://example.com/biologia.mp4', '2024-09-16');

-- Inserción en la tabla Asistencia
INSERT INTO Asistencia (id_sesion, id_alumno, fecha, estado) VALUES
                                                                 (1, 1, '2024-09-18', 'Presente'),
                                                                 (2, 2, '2024-09-19', 'Ausente');

-- Inserción en la tabla Evaluaciones
INSERT INTO Evaluaciones (id_sesion, id_alumno, calificacion, comentario, fecha_evaluacion) VALUES
                                                                                                (1, 1, 4.5, 'Buen desempeño en la sesión de álgebra.', '2024-09-19'),
                                                                                                (2, 2, 3.8, 'Faltaron algunas participaciones importantes.', '2024-09-20');

-- Inserción en la tabla ValoracionesTutores
INSERT INTO ValoracionesTutores (id_tutor, id_alumno, calificacion, comentario, fecha_valoracion) VALUES
                                                                                                      (1, 1, 5, 'Excelente tutor, muy claro en las explicaciones.', '2024-09-20'),
                                                                                                      (2, 2, 4, 'Buen tutor, aunque podría mejorar en la dinámica de la clase.', '2024-09-21');
