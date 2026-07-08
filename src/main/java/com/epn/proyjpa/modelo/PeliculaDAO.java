package com.epn.proyjpa.modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO implements Crud {
    private Connection conn;

    public PeliculaDAO() {
        this.conn = new Conexion().conectar();
    }

    @Override
    public List<Pelicula> listarTodas() {
        List<Pelicula> lista = new ArrayList<>();
        if (conn == null) {
            System.err.println("❌ No hay conexión a la base de datos");
            return lista;
        }
        String sql = "SELECT * FROM peliculas";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pelicula p = new Pelicula();
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setDirector(rs.getString("director"));
                p.setAnio(rs.getInt("anio"));
                p.setGenero(rs.getString("genero"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public Pelicula buscar(Integer id) {
        if (conn == null) return null;
        String sql = "SELECT * FROM peliculas WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Pelicula p = new Pelicula();
                p.setId(rs.getInt("id"));
                p.setTitulo(rs.getString("titulo"));
                p.setDirector(rs.getString("director"));
                p.setAnio(rs.getInt("anio"));
                p.setGenero(rs.getString("genero"));
                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertar(Pelicula pelicula) {
        if (conn == null) return;
        String sql = "INSERT INTO peliculas (titulo, director, anio, genero) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, pelicula.getTitulo());
            ps.setString(2, pelicula.getDirector());
            ps.setInt(3, pelicula.getAnio());
            ps.setString(4, pelicula.getGenero());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actualizar(Pelicula p) {
        if (conn == null) return;
        String sql = "UPDATE peliculas SET titulo=?, director=?, anio=?, genero=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, p.getTitulo());
            ps.setString(2, p.getDirector());
            ps.setInt(3, p.getAnio());
            ps.setString(4, p.getGenero());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eliminar(Integer id) {
        if (conn == null) return;
        String sql = "DELETE FROM peliculas WHERE id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}