package com.example.pizzeria.Enums;

public enum TipoSalsa {

    YOGURT("Salsa yogurt"),PICANTE("Salsa picante"),NINGUNA("Sin salsa"),AMBAS("Ambas salsas");

    private String salsa;
    TipoSalsa(String cadena) {
        this.salsa=cadena;
    }

    public String getSalsa() {
        return salsa;
    }

}
