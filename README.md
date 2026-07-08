# Sistema de Login y Gestión de Productos - JavaFX + MySQL + BCrypt

Aplicación de escritorio desarrollada en Java con JavaFX y MySQL que implementa un sistema de autenticación seguro mediante BCrypt y control de acceso basado en roles (ADMIN, VENDEDOR y CLIENTE). Además, incorpora un módulo CRUD completo para la gestión de productos con permisos dinámicos según el rol del usuario autenticado.

## ✨ Funcionalidades

- Registro de nuevos usuarios con contraseñas protegidas mediante BCrypt.
- Inicio de sesión con validación de credenciales utilizando hash.
- Control de acceso basado en roles (RBAC).
- Tres roles de usuario:
  - ADMIN
  - VENDEDOR
  - CLIENTE
- CRUD completo de productos.
- Búsqueda de productos.
- Reporte de productos en consola.
- Interfaz gráfica desarrollada con JavaFX y FXML.
- Cierre de sesión con retorno a la pantalla de inicio de sesión.
- Restricción dinámica de botones y acciones según el rol del usuario.

## 🛠️ Tecnologías utilizadas

- Java 21
- JavaFX 21
- MySQL 8.0+
- JDBC
- jBCrypt
- Maven

## 📦 Estructura del proyecto

```text
crudproductos/

├── src/
│   └── main/
│       ├── java/
│       │   └── org/epn/crudproductosmelvasuarez/
│       │       ├── Application.java
│       │       ├── Launcher.java
│       │       ├── controlador/
│       │       │   ├── LoginController.java
│       │       │   └── CatalogosProdController.java
│       │       └── modelo/
│       │           ├── Conexion.java
│       │           ├── Crud.java
│       │           ├── ImplCrud.java
│       │           ├── Producto.java
│       │           ├── Seguridad.java
│       │           ├── Usuario.java
│       │           └── UsuarioDAO.java
│       └── resources/
│           ├── Login.fxml
│           └── Catalogo_Productos.fxml
│
├── pom.xml
├── module-info.java
└── README.md
```

## ⚙️ Configuración de la Base de Datos

1. Instala MySQL Server.

2. Crea una base de datos llamada:

```text
control_productos
```

3. Ejecuta el script SQL para crear las tablas necesarias.

> **Nota:** El script completo de la base de datos (creación de tablas e inserción de usuarios de prueba) se encuentra disponible en la rama **`database`** de este repositorio.

4. Configura la conexión en la clase `Conexion.java`:

```java
private static final String JDBC_URL = "jdbc:mysql://localhost:3307/control_productos";
private static final String JDBC_USER = "root";
private static final String JDBC_PASSWORD = "";
```

Modifica el puerto, usuario y contraseña según tu configuración de MySQL.

## 🔧 Configuración del proyecto

### Requisitos

- JDK 21 o superior.
- JavaFX 21.
- MySQL Server 8.0 o superior.
- Maven.
- IntelliJ IDEA (recomendado) o cualquier IDE compatible con JavaFX.

### Dependencias

El proyecto utiliza Maven para gestionar automáticamente las dependencias.

Entre las principales se encuentran:

- JavaFX Controls
- JavaFX FXML
- MySQL Connector/J
- jBCrypt

Todas ellas ya están declaradas en el archivo `pom.xml`.

## 🚀 Ejecución

1. Clona el repositorio.

```bash
git clone https://github.com/tu_usuario/tu_repositorio.git
```

2. Abre el proyecto como proyecto Maven en IntelliJ IDEA.

3. Espera que Maven descargue todas las dependencias.

4. Configura la conexión a MySQL.

5. Ejecuta la clase:

```text
Launcher.java
```

O desde la terminal:

```bash
mvn clean compile
mvn javafx:run
```

## 🔐 Roles del sistema

### ADMIN

Tiene acceso completo al sistema.

- Insertar productos
- Modificar productos
- Eliminar productos
- Buscar productos
- Mostrar productos
- Imprimir reportes

### VENDEDOR

Tiene acceso limitado.

Puede:

- Insertar productos
- Eliminar productos
- Buscar productos
- Mostrar productos
- Imprimir reportes

No puede:

- Modificar productos

### CLIENTE

Solo puede consultar información.

Puede:

- Buscar productos
- Visualizar productos
- Imprimir reportes

No puede:

- Crear productos
- Modificar productos
- Eliminar productos

## 📄 Reporte

La opción **Imprimir Reporte** genera un listado tabular de todos los productos registrados mostrando la información directamente en la consola.

## 🔒 Seguridad

El sistema implementa autenticación segura mediante BCrypt.

Características:

- Las contraseñas nunca se almacenan en texto plano.
- Se guarda únicamente el hash BCrypt.
- Validación mediante:

```java
BCrypt.checkpw(passwordIngresada, hashAlmacenado);
```

- Uso de `PreparedStatement` para prevenir ataques de inyección SQL.

## 👤 Autora

**Melva Suárez**  
Programación Orientada a Objetos

## 📌 Mejoras futuras

- Recuperación de contraseña.
- Gestión de categorías de productos.
- Exportación de reportes a PDF.
- Exportación a Excel.
- Auditoría de acciones por usuario.
- Dashboard con estadísticas.
- Validaciones adicionales en formularios.

## 📜 Licencia

Este proyecto fue desarrollado con fines académicos y educativos. Puede utilizarse, modificarse y adaptarse libremente respetando la autoría correspondiente.
