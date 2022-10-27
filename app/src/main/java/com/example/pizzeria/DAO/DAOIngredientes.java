package com.example.pizzeria.DAO;

import java.util.ArrayList;

public class DAOIngredientes {
    private ArrayList<String> daoIngredientes;
    private static DAOIngredientes dao=null;
    private DAOIngredientes(){
        daoIngredientes= new ArrayList<String>();
        daoIngredientes.add("Piña");
        daoIngredientes.add("Atun");
        daoIngredientes.add("Aceitunas negras");
        daoIngredientes.add("Bacon");
        daoIngredientes.add("Bacon crispy");
        daoIngredientes.add("Ternera");
        daoIngredientes.add("Pollo");
        daoIngredientes.add("Pollo Marinado");
        daoIngredientes.add("Pimiento");
        daoIngredientes.add("Jamon York");
        daoIngredientes.add("Salsa BBQ");
        daoIngredientes.add("Salsa Azul");
        daoIngredientes.add("Nata");

    }

    public static DAOIngredientes getInstance(){
        if(dao==null) dao=new DAOIngredientes();
        return null;
    }
}
