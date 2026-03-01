# Planner API - Spring Boot + JPA + H2

Proyecto académico para gestionar `Usuarios`, `Planners` y `Journals` con relaciones JPA.

## Tecnologías
- Java 17+
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- H2 Database (en memoria)
- Maven Wrapper (`mvnw`, `mvnw.cmd`)

## Modelo de dominio
- `Usuario` 1 --- N `Planner`
- `Planner` 1 --- N `Journal`

## Requisitos previos
- Git
- JDK 17 o superior
- Internet (primera ejecución para descargar dependencias Maven)

## Clonar y ejecutar
1. Clona el repositorio:

```bash
git clone <URL_DEL_REPO>
```

2. Entra a la carpeta del proyecto (donde está `pom.xml`):

```powershell
cd "<RUTA_CLONADA>\Planner"
```

3. Ejecuta la aplicación:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=--server.port=8090"
```

Si el puerto `8090` está ocupado, usa otro:

```powershell
.\mvnw.cmd spring-boot:run "-Dspring-boot.run.arguments=--server.port=8091"
```

## Verificar que arrancó
En consola debe aparecer algo como:
- `Tomcat started on port 8090`
- `Started PlannerApplication`

## Configuración de base de datos (H2)
Archivo: `src/main/resources/application.properties`

```properties
spring.h2.console.enabled=true
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=Pamela
spring.datasource.password=Alma
spring.jpa.hibernate.ddl-auto=update
```

Notas:
- Al usar `h2:mem`, los datos se pierden al apagar la app.
- `ddl-auto=update` crea/ajusta tablas según entidades.

## Endpoints principales
Base URL (ejemplo): `http://localhost:8090`

- `GET /usuarios`
- `POST /usuarios`
- `GET /usuarios/{id}`
- `DELETE /usuarios/{id}`

- `GET /planners`
- `POST /planners`
- `GET /planners/{id}`
- `DELETE /planners/{id}`

- `GET /journals`
- `POST /journals`
- `GET /journals/{id}`
- `DELETE /journals/{id}`

## Pruebas rápidas con PowerShell
```powershell
# Crear usuario
Invoke-RestMethod -Method Post -Uri "http://localhost:8090/usuarios" -ContentType "application/json" -Body '{"nombre":"Pamela","email":"pamela@email.com","password":"Alma"}'

# Crear planner asociado a usuario id=1
Invoke-RestMethod -Method Post -Uri "http://localhost:8090/planners" -ContentType "application/json" -Body '{"titulo":"Semana 1","descripcion":"Plan inicial","usuario":{"id":1}}'

# Crear journal asociado a planner id=1
Invoke-RestMethod -Method Post -Uri "http://localhost:8090/journals" -ContentType "application/json" -Body '{"title":"Dia 1","content":"Avance del proyecto","planner":{"id":1}}'

# Consultar
Invoke-RestMethod -Method Get -Uri "http://localhost:8090/usuarios/1"
Invoke-RestMethod -Method Get -Uri "http://localhost:8090/planners/1"
Invoke-RestMethod -Method Get -Uri "http://localhost:8090/journals/1"
```

## H2 Console
URL:
- `http://localhost:8090/h2-console`

Parámetros:
- JDBC URL: `jdbc:h2:mem:testdb`
- User Name: `Pamela`
- Password: `Alma`

SQL útil:
```sql
SHOW TABLES;
SELECT * FROM USUARIOS;
SELECT * FROM PLANNERS;
SELECT * FROM JOURNALS;
```

## Estructura del proyecto
```text
src/main/java/Planner
  ├── controller
  ├── entity
  └── repository
src/main/resources
  └── application.properties
```

## Autor
Proyecto de práctica académica para Momento 1 (Dominio y Persistencia Inicial).
