package com.epn.proyjpa.modelo;

import java.util.List;

public interface Crud {

    public List<Pelicula> listarTodas();

    public Pelicula buscar(Integer id); //buscar una pelicula por ID

    public void insertar(Pelicula pelicula);//insertar una nueva pelicula

    public void actualizar(Pelicula p); //actualizar una pelicula

    public void eliminar(Integer id); //eliminar una pelicula
}

