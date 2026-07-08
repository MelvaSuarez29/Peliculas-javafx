package com.epn.proyjpa.modelo;

import java.util.List;

public class Servicio {
    private PeliculaDAO dao;

    public Servicio() {
        this.dao = new PeliculaDAO(); // Usa JDBC, no JPA
    }

    public List<Pelicula> obtenerTodas() {
        return dao.listarTodas();
    }

    public Pelicula buscarPorId(Integer id) {
        return dao.buscar(id);
    }

    public void registrarPelicula(Pelicula p) {
        dao.insertar(p);
    }

    public void actualizarPelicula(Pelicula p) {
        dao.actualizar(p);
    }

    public void eliminarPelicula(Integer id) {
        dao.eliminar(id);
    }
}