package com.epn.proyjpa.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String titulo;
    @Column(length = 100)
    private String director;
    private Integer anio;
    @Column(length = 50)
    private String genero;

    public Pelicula() {}

    public Pelicula(Integer id, String titulo, String director, Integer anio, String genero) {
        this.id = id;
        this.titulo = titulo;
        this.director = director;
        this.anio = anio;
        this.genero = genero;
    }

    public Integer getId() {return id;}
    public void setId(Integer id) {this.id = id;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getDirector() {return director;}
    public void setDirector(String director) {this.director = director;}
    public Integer getAnio() {return anio;}
    public void setAnio(Integer anio) {this.anio = anio;}
    public String getGenero() {return genero;}
    public void setGenero(String genero) {this.genero = genero;}

    @Override
    public String toString() {
        return "Pelicula\t" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", director='" + director + '\'' +
                ", anio=" + anio +
                ", genero='" + genero + '\'';
    }
}
