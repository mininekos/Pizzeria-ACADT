package com.example.pizzeria.Recursos;

import java.util.Objects;

public class Usuario {

    private String nombre;
    private String contrasenna;
    private String email;

    public Usuario(String nombre, String contrasenna, String email) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.email = email;
    }

    public Usuario(String nombre, String contrasenna) {
        this.nombre = nombre;
        this.contrasenna = contrasenna;
        this.email = "email";
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return getNombre().equals(usuario.getNombre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}
