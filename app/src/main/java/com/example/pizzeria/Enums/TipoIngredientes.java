package com.example.pizzeria.Enums;

public enum TipoIngredientes {

    LECHUGA(0,"Lechuga"),CEBOLLA(0,"Cebolla"),TOMATE(0,"Tomate"),MAIZ(0,"Maiz"),ACEITUNAS(0,"Aceitunas"),
    COL(0,"Col"),QUESO_SUAVE(0.5,"Queso suave"),QUESO_FETA(0.5,"Queso feta"),EXTRA_CARNE(0.5,"Extra carne"),
    PATATAS(0.5,"Patatas dentro"),HUEVO(0.5,"Huevo");

    private double precio;
    private String ingrediente;

    TipoIngredientes(double valor, String cadena) {
        precio=valor;
        ingrediente=cadena;
    }

    public double getPrecio() {
        return precio;
    }

    public String getIngrediente() {
        return ingrediente;
    }
}
