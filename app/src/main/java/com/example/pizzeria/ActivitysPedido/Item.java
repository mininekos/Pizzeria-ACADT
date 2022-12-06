package com.example.pizzeria.ActivitysPedido;

import android.graphics.drawable.Drawable;

public class Item {
    private Drawable imagenKebab;
    private String nombreKebab;

    public Item(Drawable imageSRC, String name) {
        this.imagenKebab = imageSRC;
        this.nombreKebab = name;

    }

    public Drawable getImagenKebab() {
        return imagenKebab;
    }

    public void setImagenKebab(Drawable imagenKebab) {
        this.imagenKebab = imagenKebab;
    }

    public String getNombreKebab() {
        return nombreKebab;
    }

    public void setNombreKebab(String nombreKebab) {
        this.nombreKebab = nombreKebab;
    }
}
