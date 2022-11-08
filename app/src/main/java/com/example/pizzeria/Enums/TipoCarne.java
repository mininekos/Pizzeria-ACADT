package com.example.pizzeria.Enums;

public enum TipoCarne {

    POLLO("Pollo"),TERNERA("Ternera"),Mixto("Mixto"),Falafel("Falafel");

    private String tipoCarne;

    TipoCarne(String tipo) {
        tipoCarne=tipo;
    }

    public String getTipoCarne() {
        return tipoCarne;
    }
}
