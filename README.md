# 🎬 Gestor de Películas - JavaFX + JPA + MySQL

Aplicación de escritorio para el registro y consulta de películas, desarrollada en **Java** utilizando **JavaFX**, **JPA (Hibernate)** y **MySQL** como sistema de gestión de base de datos. La aplicación implementa operaciones CRUD completas sobre el catálogo de películas mediante persistencia con JPA.

---

## ✨ Funcionalidades

- Insertar nuevas películas.
- Modificar películas existentes.
- Eliminar películas por ID.
- Buscar películas por ID.
- Mostrar la información de una película seleccionada.
- Imprimir un reporte completo de películas en consola.
- Tabla de películas con actualización en tiempo real.
- Persistencia de datos mediante JPA (Hibernate).

---

## 🛠️ Tecnologías utilizadas

- Java 17+
- JavaFX 17+
- JPA (Jakarta Persistence)
- Hibernate ORM
- MySQL 8.0+
- MySQL Connector/J
- Maven
- Java Platform Module System (JPMS)

---

## 📦 Estructura del proyecto

```text
proyjpa/
├── src/
│   └── com/epn/proyjpa/
│       ├── modelo/
│       │   ├── Pelicula.java              # Entidad JPA (@Entity)
│       │   ├── PeliculaDAO.java           # Operaciones CRUD con JPA
│       │   ├── Servicio.java              # Lógica de negocio
│       │   ├── Conexion.java              # Configuración de conexión
│       │   ├── Crud.java                  # Interfaz CRUD
│       │   └── TestConexion.java          # Prueba de conexión
│       ├── CatalogoPeliculasController.java
│       ├── HelloApplication.java
│       ├── HelloController.java
│       ├── Launcher.java
│       └── peliculas.fxml
│
├── src/main/resources/
│   └── META-INF/
│       └── persistence.xml
│
├── module-info.java
├── pom.xml
└── README.md
```

---

## ⚙️ Configuración de la Base de Datos

1. Instala y ejecuta MySQL Server.

2. Crea una base de datos llamada:

```text
cine
```

3. Ejecuta el script SQL para crear la tabla **peliculas**.

> **Nota:** El script completo de creación de la base de datos y los datos de ejemplo se encuentra disponible en la rama **`database`** de este repositorio.

4. Configura las credenciales de conexión en el archivo **Conexion.java**:

```java
private static final String JDBC_URL = "jdbc:mysql://localhost:3307/cine";
private static final String JDBC_USER = "root";
private static final String JDBC_PASSWORD = "";
```

5. Verifica que el archivo **persistence.xml** tenga configurada correctamente la unidad de persistencia y la conexión a tu base de datos.

---

## 🔧 Configuración del proyecto

### Requisitos

- JDK 17 o superior.
- JavaFX 17 o superior.
- MySQL Server 8.0 o superior.
- Maven.
- IntelliJ IDEA o Eclipse con soporte para JavaFX.

### Dependencias principales

El proyecto utiliza Maven para administrar automáticamente las dependencias.

- JavaFX Controls
- JavaFX FXML
- Jakarta Persistence
- Hibernate ORM
- MySQL Connector/J

Todas las dependencias ya se encuentran configuradas en el archivo **pom.xml**.

---

## 🚀 Ejecución

1. Clona el repositorio.

```bash
git clone https://github.com/MelvaSuarez29/proyjpa.git
```

2. Ingresa al directorio del proyecto.

```bash
cd projjpa
```

3. Abre el proyecto en IntelliJ IDEA o Eclipse.

4. Espera que Maven descargue las dependencias.

5. Verifica la conexión con MySQL.

6. Ejecuta la clase:

```text
Launcher.java
```

O desde la terminal:

```bash
mvn clean compile
mvn javafx:run
```

---

## 📄 Reporte en consola

Al presionar el botón **Imprimir Reporte**, el sistema genera un listado completo de todas las películas almacenadas en la base de datos y lo muestra en la consola.

---

## 👤 Autora

**Melva Suárez**
---

## 📌 Mejoras futuras

- Búsqueda por título.
- Búsqueda por director.
- Filtros por género.
- Exportación de reportes a PDF.
- Exportación de reportes a Excel.
- Internacionalización (i18n).
- Temas claro y oscuro para la interfaz.

---

## 📜 Licencia

Este proyecto se distribuye con fines educativos y académicos. Puedes utilizarlo y modificarlo libremente respetando la autoría correspondiente.
