package com.example.pizzeria.Enums;

public enum TipoCarne {

    POLLO("Pollo"),TERNERA("Ternera"),MIXTO("Mixto"),FALAFEL("Falafel");

    private String tipoCarne;

    TipoCarne(String tipo) {
        tipoCarne=tipo;
    }

    public String getTipoCarne() {
        return tipoCarne;
    }

    @Override
    public String toString() {
        return tipoCarne;

    }
}
