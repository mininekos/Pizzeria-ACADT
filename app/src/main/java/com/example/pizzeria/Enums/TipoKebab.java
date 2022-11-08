package com.example.pizzeria.Enums;

public enum TipoKebab {

    lAHMACUM(4,"Lahmacum"),DURUM(3.5,"Durum"),DONNER(3,"Donner"),PLATO_KEBAB(6,"Plato Kebab");

    private double precioKebab;
    private String kebab;

    TipoKebab(double precio, String tipoKebab) {
        this.precioKebab=precio;
        this.kebab=tipoKebab;
    }

    public double getPrecioKebab() {
        return precioKebab;
    }

    public String getKebab() {
        return kebab;
    }
}
