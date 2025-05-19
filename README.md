# DS_Restaurante
DS_Restaurante es un sistema de gestión de reservaciones para un restaurante, desarrollado como parte de una arquitectura distribuida basada en Java. El proyecto está dividido en múltiples módulos siguiendo principios de diseño limpio y buenas prácticas de programación.

Características principales
* Gestión de clientes, mesas, meseros y reservaciones.
* Uso de Data Transfer Objects (DTOs) para comunicación entre capas.
* Implementación de lógica de negocio a través de interfaces y clases de negocio (BO).
* Separación clara entre capas de entidad, lógica de negocio y persistencia.
* Configuración de JPA para la persistencia de datos.

Estructura del proyecto
DTO_NegocioE1: Contiene las entidades principales del sistema (Cliente, Mesa, Mesero, Reservación) y sus respectivos DTOs.
Negocio_Reservacion: Contiene la lógica de negocio e interfaces relacionadas con la gestión de reservaciones y asignación de mesas.

Tecnologías utilizadas
* Java
* JPA (Java Persistence API)
* Maven para la gestión de dependencias
