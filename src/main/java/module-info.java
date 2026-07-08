module com.epn.proyjpa {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;        // ← OBLIGATORIO
    requires org.hibernate.orm.core;
    requires java.sql;                   // ← Añade esto también

    // JavaFX necesita acceso al paquete principal
    // Hibernate necesita acceso por reflexión a las entidades
    opens com.epn.proyjpa.modelo to org.hibernate.orm.core;
    exports com.epn.proyjpa;
    exports com.epn.proyjpa.modelo;
    opens com.epn.proyjpa to javafx.fxml, org.hibernate.orm.core;
}