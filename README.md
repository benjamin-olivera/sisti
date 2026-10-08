# SISTI

Proyecto web Java (Maven + JSP/Servlet + JPA/Hibernate + MySQL) para gestión de inventario.

## Requisitos

- Java **11** (JDK)
- Maven **3.8+**
- MySQL **8.x**
- Apache Tomcat **10.1.x**
- Eclipse IDE (opcional, recomendado)

## Tecnologías usadas

- Jakarta Persistence API 3.1
- Hibernate ORM 6.4
- MySQL Connector/J 8.4
- Jakarta Servlet 6
- JSTL 3

## Estructura esperada

- `src/main/java` → código Java (DAO, modelos, etc.)
- `src/main/webapp` → vistas JSP y recursos web
- `src/main/resources/META-INF/persistence.xml` → configuración JPA
- `pom.xml` → dependencias Maven

## Configuración de base de datos

1. Crear la base de datos (por ejemplo `sisti`) en MySQL.
2. Importar el script SQL del proyecto (si aplica).
3. Editar `src/main/resources/META-INF/persistence.xml` con tus credenciales locales:

```xml
<property name="jakarta.persistence.jdbc.url"
          value="jdbc:mysql://localhost:3306/sisti?useSSL=false&amp;serverTimezone=UTC&amp;allowPublicKeyRetrieval=true"/>

<property name="jakarta.persistence.jdbc.user" value="TU_USUARIO"/>
<property name="jakarta.persistence.jdbc.password" value="TU_PASSWORD"/>
```

> ⚠️ No subir credenciales reales al repositorio.

## Cómo ejecutar en Eclipse (Tomcat)

1. Importar el proyecto como **Maven Project**.
2. Clic derecho al proyecto → **Maven > Update Project**.
3. Configurar servidor **Tomcat 10.1** en Eclipse.
4. Clic derecho al proyecto → **Run As > Run on Server**.
5. Abrir en navegador:
   - `http://localhost:8080/sisti/`
   - o `http://localhost:8080/sisti/index.jsp`

## Comandos útiles Git

```bash
git status
git add .
git commit -m "mensaje"
git push
```

## Notas

- Si aparece error de conexión a MySQL, verificar usuario/password y existencia de la base de datos.
- Si Tomcat no inicia por `Bootstrap`, revisar que Tomcat esté bien descomprimido (carpetas `bin`, `conf`, `lib`, `webapps`).
