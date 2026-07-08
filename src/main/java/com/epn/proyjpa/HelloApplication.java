package com.epn.proyjpa;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Carga el FXML desde el mismo paquete
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("peliculas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 680);
        stage.setTitle("CrudPeliculas Melva Suarez");
        stage.setScene(scene);
        stage.show();
    }
}