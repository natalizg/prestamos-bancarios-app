# PrestamosBancariosApp

API REST de flujo básico CRUD desarrollada con Java y Spring Boot para la gestión de solicitudes de préstamos bancarios.
Permite crear solicitudes, consultar su historial y modificar su estado siguiendo un flujo de negocio definido.


## Funcionalidades

- Crear una solicitud de préstamo bancario
- Consultar todas las Solicitudes
- Consultar una solicitud por Id
- Actualización del estado de una solicitud
- Validación de datos de entrada
- Manejo básico global de excepciones


## Arquitectura del proyecto

El proyecto sigue una arquitectura en capas para su futuro escalado y organización clara:

### Estructura de paquetes

- controller      → Endpoints REST
- domain          → Entidades del dominio
- dto             → Objetos de transferencia de datos
- enums           → Estados del préstamo
- exception       → Manejo global de errores
- mapper          → Conversión Entity ↔ DTO (MapStruct)
- repository      → Acceso a datos (JPA / H2)
- service // serviceImpl  → Lógica de negocio
- PrestamosBancariosAppApplication

## Tecnologías utilizadas

- Java 17
- Spring Boot 4
- Spring Web / REST
- Spring Data JPA
- Base de datos en memoria H2
- MapStruct
- Lombok
- Jakarta Validation
- Hibernate Validator


## Instrucciones para ejecutar el proyecto

- Java 17 o superior
- Maven 3+
- Puerto http://localhost:8080 libre

> Pruebas

Se incluye una colección de Postman dentro de la carpeta _resources_: Préstamos Bancarios.postman_collection.json


Con ella se pueden probar:

Creación de solicitudes

Consulta de solicitudes

Cambio de estado


## Posibles mejoras y extensiones

Con más tiempo, se podrían implementar las siguientes mejoras:

- Autenticación y autorización (Spring Security, JWT)
- Tests unitarios y de integración
- Documentación con Swagger / OpenAPI
- Dockerización del proyecto
- Filtros y paginación en consultas
- Auditoría de acciones

## 👤 Autor

Proyecto desarrollado por Natalia Zarzuela Giráldez
