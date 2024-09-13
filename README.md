## Introducción

**AprendeYa** es una plataforma web diseñada para facilitar la conexión entre estudiantes y tutores especializados en diversas materias académicas. En AprendeYa, los usuarios pueden crear una cuenta, explorar perfiles de tutores, y reservar sesiones de tutoría personalizadas de manera rápida y eficiente. La plataforma permite a los tutores ofrecer tanto tutorías individuales como grupales, y a los estudiantes seleccionar al tutor que mejor se ajuste a sus necesidades, basándose en comentarios y calificaciones previas.

Con el propósito de optimizar el rendimiento académico, AprendeYa ofrece una experiencia de aprendizaje adaptada a las necesidades específicas de cada alumno, garantizando un entorno de aprendizaje flexible, accesible y seguro.

### Colaboradores del Proyecto

| **Nombre**             | **Rol**             | **Perfil**                                                 |
|------------------------|---------------------|------------------------------------------------------------|
| Emerson Lezama Vera    | Líder del Proyecto  | [LinkedIn]()           |
| Juan Valeriano Benites | Integrante Proyecto | [LinkedIn]()           |

### Revisa el Progreso del Proyecto BookHub

| **Columna**       | **Descripción**                                                                                                                                    |
|-------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Backlog**       | Contiene todas las historias de usuario, tareas y características que deben desarrollarse. Es el listado de todo el trabajo pendiente.              |
| **En Progreso**   | Incluye las tareas que están actualmente en desarrollo. Visualiza el trabajo en curso para asegurar el flujo continuo de trabajo.                   |
| **Revisión**      | Después de completar una tarea, se mueve aquí para una revisión de código y revisión por pares (peer review). Esta fase incluye la creación de **pull requests** para asegurar que el código cumpla con los estándares de calidad antes de integrarse al proyecto principal. |
| **En Pruebas**    | Contiene las tareas que han pasado la revisión de código y necesitan pruebas exhaustivas (unitarias, de integración y de aceptación) para garantizar su calidad. |
| **Hecho**         | Las tareas completamente desarrolladas, revisadas y probadas se mueven aquí, indicando que están listas y finalizadas.                               |

Mira cómo va avanzando nuestro trabajo visitando el siguiente enlace: [Tablero de Trello](https://trello.com/b/i621bTDB/transaccional).


### Funcionalidades de la Aplicación Aprendeya

#### **Módulo de Gestión de Usuarios**

- **Registro y Gestión de Perfiles:**
    - Permitir a los usuarios registrarse en la plataforma.
    - Facilitar la gestión de perfiles, donde los tutores pueden detallar sus especializaciones, disponibilidad y tarifas.
    - Los estudiantes podrán personalizar sus intereses académicos y preferencias de aprendizaje.

#### **Módulo de Búsqueda y Selección de Tutores**

- **Busqueda Avanzada:**
    - Los estudiantes podrán buscar tutores según materia, calificaciones, disponibilidad y tarifas.
    - Visualización de perfiles detallados de tutores, incluyendo credenciales y comentarios de otros estudiantes.
    - Permitir a los estudiantes filtrar tutores según años de experiencia.

- **Reservas de Sesiones:**
    - Permitir a los estudiantes reservar sesiones de tutoría individuales o grupales.
    - Facilitar la selección de fechas y horarios para las sesiones.
    - Enviar notificaciones por correo electrónico o mensaje de texto para confirmar la reserva de sesiones y recordatorios.

#### **Módulo de Pagos en Línea**

- **Pago de Servicios**
    - Integración de un sistema de pagos en línea para que los estudiantes paguen por las sesiones de tutoría.
    - Opciones para pagos por sesión o suscripciones a paquetes de tutoría.
    - Ofrecer múltiples métodos de pago, incluyendo tarjetas de crédito, débito y opciones de pago digital como PayPal.

- **Gestión de Transacciones:**
    - Visualización del historial de pagos y obtención de recibos.
    - Gestión de métodos de pago.
    - Permitir a los usuarios acceder a un historial completo de sus transacciones, con detalles de fechas, montos y métodos de pago utilizados.

#### **Módulo de Gestión de Sesiones y Materiales Educativos**

- **Subida y Gestión de Materiales:**
    - Permitir a los tutores subir documentos, videos y otros materiales educativos.
    - Facilitar la revisión de materiales por parte de los estudiantes antes o después de las sesiones.
    - Aceptar diversos formatos de archivos (PDF, Word, Excel, videos)

- **Registro de Asistencia:**
    - Funcionalidad para registrar la asistencia a las sesiones.
    - Mantenimiento de un historial de interacciones entre estudiantes y tutores.

#### **Módulo de Reportes y Evaluación del Progreso**

- **Reportes de Rendimiento:**
    - Generación de reportes gráficos sobre el progreso de los estudiantes.
    - Inclusión de estadísticas de asistencia, calificaciones y recomendaciones para mejorar el rendimiento.

- **Feedback y Evaluaciones:**
    - Evaluación del desempeño del estudiante por parte del tutor.
    - Provisión de feedback para el desarrollo académico del estudiante.


## Diagramas de la Aplicación

Para entender mejor la estructura y diseño de la aplicación "Aprendeya", revisa los siguientes diagramas:

### Diagrama de Clases

![Diagrama de Clases](diagrama_clase.png)


### Diagrama de Base de Datos

![Diagrama de Base de Datos](diagrama_base_datos.png)

Este diagrama ilustra el esquema de la base de datos utilizada por la aplicación, mostrando las tablas, columnas, y relaciones entre las entidades.

### Descripción de Capas del Proyecto

| capa        | descripción                                                                                  |
|-------------|----------------------------------------------------------------------------------------------|
| api         | Contiene los controladores REST que manejan las solicitudes HTTP y las respuestas.            |
| entity      | Define las entidades del modelo de datos que se mapean a las tablas de la base de datos.      |
| repository  | Proporciona la interfaz para las operaciones CRUD y la interacción con la base de datos.      |
| service     | Declara la lógica de negocio y las operaciones que se realizarán sobre las entidades.         |
| service impl| Implementa la lógica de negocio definida en los servicios, utilizando los repositorios necesarios. |

# Asignación de Historias de Usuario


**Sprint 1:** Funcionalidades Básicas  
*Enfocado en implementar las funcionalidades esenciales para la gestión de usuarios, búsqueda de tutores, reserva de sesiones, pagos en línea y gestión de materiales educativos, asegurando que la plataforma esté lista para ofrecer tutorías personalizadas..*

| Integrante  | Módulo                           | Historia de Usuario                          | Descripción                                                                                         | Tipo |
|-------------|----------------------------------|-----------------------------------------------|-----------------------------------------------------------------------------------------------------|------|
| Integrante 1 | Gestión de Tutorías               | HU01: Registro de Tutorías                   | Como estudiante, quiero registrar mis sesiones de tutoría, para llevar un seguimiento de mis clases. | CRUD |
|             |                                  | HU02: Cancelación de Tutorías                | Como estudiante, quiero cancelar sesiones de tutoría programadas, para reprogramar o cancelar mi asistencia. | CRUD |
| Integrante 2 | Gestión de Sesiones               | HU03: Programación de Sesiones               | Como tutor, quiero programar nuevas sesiones de tutoría, para gestionar mis disponibilidades.         | CRUD |
|             |                                  | HU04: Modificación de Sesiones               | Como tutor, quiero modificar detalles de las sesiones programadas, para ajustar mi disponibilidad o contenido. | CRUD |
| Integrante 3 | Gestión de Pagos                  | HU05: Pago por Sesión                        | Como estudiante, quiero poder pagar por las sesiones de tutoría que reservo, para confirmar mi asistencia. | CRUD |
|             |                                  | HU06: Suscripción a Paquetes de Tutoría      | Como estudiante, quiero suscribirme a paquetes de tutoría, para obtener un descuento en múltiples sesiones. | CRUD |
| Integrante 4 | Gestión de Materiales Educativos | HU07: Subida de Materiales Educativos        | Como tutor, quiero subir materiales educativos, para proporcionar recursos adicionales a los estudiantes. | CRUD |
|             |                                  | HU08: Descarga de Materiales Educativos      | Como estudiante, quiero poder descargar los materiales educativos subidos por el tutor, para estudiarlos offline. | CRUD |
| Integrante 5 | Gestión de Reportes y Evaluaciones | HU09: Registro de Asistencia                | Como tutor, quiero registrar la asistencia de los estudiantes a las sesiones, para mantener un historial de participación. | CRUD |
|             |                                  | HU10: Provisión de Feedback                  | Como tutor, quiero ofrecer feedback detallado después de cada sesión, para ayudar al estudiante en su desarrollo académico. | CRUD |


**Sprint 2:** Integración de Funcionalidades y Optimización  
*Orientado a la implementación de funcionalidades adicionales, como filtros, reportes detallados, integración de métodos de pago, autenticación y autorización de usuarios, optimización del sistema, y exportación de datos.*

| Integrante  | Módulo                           | Historia de Usuario                          | Descripción                                                                                         | Tipo |
|-------------|----------------------------------|-----------------------------------------------|-----------------------------------------------------------------------------------------------------|------|
| Integrante 1 | Gestión de Tutorías               | HU11: Confirmación de Pago por Notificación   | Como estudiante, quiero recibir una notificación de confirmación después de realizar un pago, para asegurarme de que mi transacción ha sido exitosa. | Core |
| Integrante 2 | Gestión de Sesiones               | HU12: Implementar Filtros Avanzados en Sesiones | Como tutor, quiero implementar filtros avanzados para gestionar las sesiones programadas, para una mejor organización. | Core |
| Integrante 3 | Gestión de Pagos                  | HU13: Gestión de Métodos de Pago              | Como usuario, quiero gestionar mis métodos de pago, para mantenerlos actualizados y seguros. | Core |
|             |                                  | HU14: Visualización de Historial de Transacciones | Como usuario, quiero visualizar mi historial de pagos, para mantener un registro claro de mis gastos en tutorías. | Core |
| Integrante 4 | Gestión de Materiales Educativos | HU15: Notificación de Subida de Materiales    | Como estudiante, quiero recibir notificaciones cuando un tutor suba nuevos materiales educativos, para estar al tanto de los recursos adicionales disponibles. | Core |
| Integrante 5 | Gestión de Reportes y Evaluaciones | HU16: Generación de Reportes de Rendimiento | Como tutor, quiero generar reportes gráficos sobre el progreso de los estudiantes, para evaluar su rendimiento y ofrecer recomendaciones. | Core |
|             |                                  | HU17: Solicitud de Reporte de Rendimiento por Estudiantes | Como estudiante, quiero solicitar un reporte de mi rendimiento académico, para entender mi progreso y áreas de mejora. | Core |
| Integrante 6 | Acceso a Reportes para Padres e Instituciones | HU18: Acceso a Reportes de Progreso para Padres | Como padre, quiero acceder a los reportes de progreso de mi hijo, para monitorizar su rendimiento académico. | Core |
|             |                                  | HU19: Acceso a Feedback de Tutores para Instituciones | Como institución, quiero acceder al feedback proporcionado por los tutores, para evaluar el rendimiento de los estudiantes bajo mi supervisión. | Core |


## Recomendaciones

1. **Comunicación Constante:** Mantener una comunicación abierta y constante entre todos los miembros del equipo para resolver dudas y compartir avances. Utilizar herramientas colaborativas como Slack o Microsoft Teams para facilitar la interacción.

2. **Revisión de Código:** Implementar prácticas de revisión de código entre pares para asegurar la calidad del software y fomentar el aprendizaje mutuo. Esto ayudará a detectar errores a tiempo y a mejorar la calidad del código entregado.

3. **Gestión del Tiempo:** Planificar y gestionar bien el tiempo para cada historia de usuario, priorizando aquellas que son críticas para el funcionamiento básico del sistema. Utilizar técnicas como el método Pomodoro para mantener la concentración y eficiencia.

4. **Pruebas Continuas:** Realizar pruebas continuas de las funcionalidades desarrolladas para identificar y corregir errores tempranamente. Asegurar que cada historia de usuario esté completamente probada antes de considerarla terminada.

5. **Documentación Clara:** Mantener una documentación clara y actualizada del código y de las decisiones tomadas durante el desarrollo. Esto facilitará el mantenimiento y futuras mejoras del producto.

6. **Retroalimentación Regular:** Programar sesiones regulares de retroalimentación al final de cada sprint para evaluar lo que funcionó bien y qué se puede mejorar. Utilizar estas sesiones para ajustar las estrategias y métodos de trabajo según sea necesario.

7. **Enfoque en el Usuario:** Mantener siempre al usuario final en mente durante el desarrollo. Asegurar que todas las funcionalidades implementadas aporten valor al usuario y mejoren su experiencia con la plataforma.

8. **Gestión de Riesgos:** Identificar posibles riesgos que puedan afectar el desarrollo del proyecto y planificar estrategias para mitigarlos. Esto incluye problemas técnicos, falta de recursos o cambios en los requisitos.

9. **Optimización del Rendimiento:** Asegurarse de que las funcionalidades añadidas no comprometan el rendimiento del sistema. Realizar pruebas de carga y optimización cuando sea necesario para garantizar una experiencia de usuario fluida.

10. **Preparación para el Lanzamiento:** A medida que se acerque el final del segundo sprint, prepararse para el lanzamiento del producto con un plan de despliegue claro, asegurando que todas las funcionalidades estén completamente probadas y documentadas.