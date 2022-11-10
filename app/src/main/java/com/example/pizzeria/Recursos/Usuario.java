package com.example.pizzeria.Recursos;

public class Usuario {

    private String nombre;
    private String contrasenna;
    private String email;

    public Usuario(String nombre, String contrasenna, String email) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.email = email;
    }

    public Usuario() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenna() {
        return contrasenna;
    }

    public void setContrasenna(String contrasenna) {
        this.contrasenna = contrasenna;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario\n" + nombre;
    }
}
