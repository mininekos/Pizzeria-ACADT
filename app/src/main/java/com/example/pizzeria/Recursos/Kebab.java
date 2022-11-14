package com.example.pizzeria.Recursos;

import com.example.pizzeria.Enums.TipoCarne;
import com.example.pizzeria.Enums.TipoIngredientes;
import com.example.pizzeria.Enums.TipoKebab;
import com.example.pizzeria.Enums.TipoSalsa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

public class Kebab implements Serializable {

    private ArrayList<TipoIngredientes> ingredientes;
    private TipoKebab tipoKebab;
    private TipoCarne carne;
    private TipoSalsa salsa;
    private Boolean favorito;
    private String nombre;
    private Integer idObligatorio;
    private static Integer cont=0;

    public Kebab() {
    }

    public Kebab(ArrayList<TipoIngredientes> ingredientes, TipoKebab tipoKebab, TipoCarne carne,TipoSalsa salsa) {
        this.ingredientes = ingredientes;
        this.tipoKebab = tipoKebab;
        this.carne = carne;
        this.salsa=salsa;
        this.favorito = false;
        idObligatorio=cont;
        Kebab.cont++;
    }

    public Kebab(String nombre,ArrayList<TipoIngredientes> ingredientes, TipoKebab tipoKebab, TipoCarne carne,TipoSalsa salsa) {
        this.nombre=nombre;
        this.ingredientes = ingredientes;
        this.tipoKebab = tipoKebab;
        this.carne = carne;
        this.salsa=salsa;
        this.favorito = false;
        idObligatorio=cont;
        Kebab.cont++;
    }

    public TipoSalsa getSalsa() {
        return salsa;
    }

    public void setSalsa(TipoSalsa salsa) {
        this.salsa = salsa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Double obtenerPrecio(){
        Double precio=0.0;
        precio+=tipoKebab.getPrecioKebab();
        for(int ind=0;ind<ingredientes.size();ind++){
            precio+=ingredientes.get(ind).getPrecio();
        }
        return precio;
    }

    @Override
    public String toString() {
        return  "Kebab: " + tipoKebab +
                "\n \tCarne: " + carne +
                "\n \tSalsa: " + salsa +
                "\n \tIngredientes: " + ingredientes ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kebab kebab = (Kebab) o;
        return idObligatorio.equals(kebab.idObligatorio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idObligatorio);
    }
}
