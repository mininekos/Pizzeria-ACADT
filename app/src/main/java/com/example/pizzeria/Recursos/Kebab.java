package com.example.pizzeria.Recursos;

import com.example.pizzeria.Enums.TipoCarne;
import com.example.pizzeria.Enums.TipoIngredientes;
import com.example.pizzeria.Enums.TipoKebab;

import java.util.ArrayList;

public class Kebab {

    private ArrayList<TipoIngredientes> ingredientes;
    private TipoKebab tipoKebab;
    private TipoCarne carne;
    private Boolean favorito;

    public Kebab(ArrayList<TipoIngredientes> ingredientes, TipoKebab tipoKebab, TipoCarne carne,Boolean favorito) {
        this.ingredientes = ingredientes;
        this.tipoKebab = tipoKebab;
        this.carne = carne;
        this.favorito = favorito;
    }

    public Kebab() {
    }

    public ArrayList<TipoIngredientes> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<TipoIngredientes> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public TipoKebab getTipoKebab() {
        return tipoKebab;
    }

    public void setTipoKebab(TipoKebab tipoKebab) {
        this.tipoKebab = tipoKebab;
    }

    public TipoCarne getCarne() {
        return carne;
    }

    public void setCarne(TipoCarne carne) {
        this.carne = carne;
    }

    public Boolean getFavorito() {
        return favorito;
    }

    public void setFavorito(Boolean favorito) {
        this.favorito = favorito;
    }

    @Override
    public String toString() {
        return  "Kebab: " + tipoKebab +
                "\n \tCarne: " + carne +
                "\n \tIngredientes: " + ingredientes ;
    }
}
