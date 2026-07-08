package com.epn.proyjpa.modelo;

public class TestConexion {
    public static void main(String[] args) {
        Conexion c = new Conexion();
        System.out.println(c.conectar());
    }
}