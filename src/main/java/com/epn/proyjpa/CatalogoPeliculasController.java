package com.epn.proyjpa;

import com.epn.proyjpa.modelo.Pelicula;
import com.epn.proyjpa.modelo.Servicio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class CatalogoPeliculasController implements Initializable {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDirector;
    @FXML private TextField txtPrecio;
    @FXML private TextField txtCodigo;

    @FXML private TableView<Pelicula> tablaProductos;
    @FXML private TableColumn<Pelicula, Integer> colId;
    @FXML private TableColumn<Pelicula, String> colProducto;
    @FXML private TableColumn<Pelicula, String> colDirector;
    @FXML private TableColumn<Pelicula, Integer> colPrecio;
    @FXML private TableColumn<Pelicula, String> colCodigo;

    private Servicio servicio;
    private ObservableList<Pelicula> listaPeliculas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            servicio = new Servicio();
            listaPeliculas = FXCollections.observableArrayList();

            colId.setCellValueFactory(new PropertyValueFactory<>("id"));
            colProducto.setCellValueFactory(new PropertyValueFactory<>("titulo"));
            colDirector.setCellValueFactory(new PropertyValueFactory<>("director"));
            colPrecio.setCellValueFactory(new PropertyValueFactory<>("anio"));
            colCodigo.setCellValueFactory(new PropertyValueFactory<>("genero"));

            configurarSeleccionTabla();
            cargarTodos();

        } catch (Exception e) {
            System.err.println("❌ Error al inicializar: " + e.getMessage());
            e.printStackTrace();
            listaPeliculas = FXCollections.observableArrayList();
            tablaProductos.setItems(listaPeliculas);
            mostrarAlerta("Error de conexión", "No se pudo conectar a la base de datos.\n" + e.getMessage());
        }
    }

    private void configurarSeleccionTabla() {
        tablaProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                txtId.setText(String.valueOf(newSelection.getId()));
                txtNombre.setText(newSelection.getTitulo());
                txtDirector.setText(newSelection.getDirector());
                txtPrecio.setText(String.valueOf(newSelection.getAnio()));
                txtCodigo.setText(newSelection.getGenero());
            }
        });
    }

    @FXML
    public void insertar() {
        try {
            if (txtNombre.getText().isEmpty() || txtPrecio.getText().isEmpty()) {
                mostrarAlerta("Error", "Debe ingresar al menos Título y Año");
                return;
            }
            Pelicula p = new Pelicula();
            p.setTitulo(txtNombre.getText());
            p.setDirector(txtDirector.getText());
            p.setAnio(Integer.parseInt(txtPrecio.getText()));
            p.setGenero(txtCodigo.getText());

            servicio.registrarPelicula(p);
            limpiarCampos();
            cargarTodos();
            mostrarAlerta("Éxito", "Película insertada correctamente");
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El año debe ser un número válido");
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo insertar: " + e.getMessage());
        }
    }

    @FXML
    public void modificar() {
        try {
            if (txtId.getText().isEmpty()) {
                mostrarAlerta("Error", "Seleccione una película o ingrese un ID");
                return;
            }
            Integer id = Integer.parseInt(txtId.getText());
            Pelicula p = servicio.buscarPorId(id);
            if (p == null) {
                mostrarAlerta("Error", "No existe película con ID " + id);
                return;
            }
            p.setTitulo(txtNombre.getText());
            p.setDirector(txtDirector.getText());
            p.setAnio(Integer.parseInt(txtPrecio.getText()));
            p.setGenero(txtCodigo.getText());

            servicio.actualizarPelicula(p);
            limpiarCampos();
            cargarTodos();
            mostrarAlerta("Éxito", "Película actualizada correctamente");
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El ID y el año deben ser números válidos");
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo modificar: " + e.getMessage());
        }
    }

    @FXML
    public void eliminar() {
        try {
            if (txtId.getText().isEmpty()) {
                mostrarAlerta("Error", "Seleccione una película o ingrese un ID");
                return;
            }
            Integer id = Integer.parseInt(txtId.getText());
            Pelicula p = servicio.buscarPorId(id);
            if (p == null) {
                mostrarAlerta("Error", "No existe película con ID " + id);
                return;
            }
            servicio.eliminarPelicula(id);
            limpiarCampos();
            cargarTodos();
            mostrarAlerta("Éxito", "Película eliminada correctamente");
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El ID debe ser un número válido");
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo eliminar: " + e.getMessage());
        }
    }

    @FXML
    public void buscar() {
        try {
            if (txtId.getText().isEmpty()) {
                mostrarAlerta("Error", "Ingrese un ID para buscar");
                return;
            }
            Integer id = Integer.parseInt(txtId.getText());
            Pelicula p = servicio.buscarPorId(id);
            if (p != null) {
                tablaProductos.getSelectionModel().select(p);
                tablaProductos.scrollTo(p);
                mostrarAlerta("Información", "Película encontrada: " + p.getTitulo());
            } else {
                mostrarAlerta("Información", "No se encontró película con ID " + id);
            }
        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El ID debe ser un número válido");
        }
    }


    @FXML
    public void mostrar() {
        Pelicula seleccionada = tablaProductos.getSelectionModel().getSelectedItem();
        if (seleccionada == null) {
            mostrarAlerta("Atención", "No hay ninguna película seleccionada.\nSeleccione una fila en la tabla.");
            return;
        }

        String mensaje = "  Mostrar Información Pelicula \n\n" +
                "ID: " + seleccionada.getId() + "\n" +
                "Título: " + seleccionada.getTitulo() + "\n" +
                "Director: " + seleccionada.getDirector() + "\n" +
                "Año: " + seleccionada.getAnio() + "\n" +
                "Género: " + seleccionada.getGenero();

        mostrarAlerta("Pelicula seleccionada", mensaje);
    }

    private void cargarTodos() {
        if (servicio == null) return;
        List<Pelicula> peliculas = servicio.obtenerTodas();
        listaPeliculas.clear();
        listaPeliculas.addAll(peliculas);
        tablaProductos.setItems(listaPeliculas);
        System.out.println("Tabla actualizada con " + peliculas.size() + " registros");
    }

    @FXML
    public void imprimirReporte() {
        try {
            if (servicio == null) {
                mostrarAlerta("Error", "No hay conexión a la base de datos");
                return;
            }
            List<Pelicula> peliculas = servicio.obtenerTodas();
            System.out.println("        Películas Registradas        ");
            System.out.println("Total: " + peliculas.size() + " registros");
            System.out.println("-----------------------------------");
            for (Pelicula p : peliculas) {
                System.out.println("ID: " + p.getId() +
                        " | Título: " + p.getTitulo() +
                        " | Director: " + p.getDirector() +
                        " | Año: " + p.getAnio() +
                        " | Género: " + p.getGenero());
            }
            System.out.println("-------------------------------------------------------");
            mostrarAlerta("Reporte", "Se generó el reporte en consola.\nTotal: " + peliculas.size() + " películas.");
        } catch (Exception e) {
            mostrarAlerta("Error", "No se pudo generar el reporte: " + e.getMessage());
        }
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtDirector.clear();
        txtPrecio.clear();
        txtCodigo.clear();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}