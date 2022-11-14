package com.example.pizzeria.DAOS;

import com.example.pizzeria.Recursos.Usuario;

import java.util.ArrayList;

public class DAOUsuario {

    private static ArrayList<Usuario> lista;
    private static DAOUsuario dao;

    public static DAOUsuario getInstance(){

        if (dao==null)
            dao=new DAOUsuario();
        if(lista==null)
            lista=new ArrayList<Usuario>();
        return dao;
    }

    public ArrayList<Usuario> getLista(){
        lista.add(new Usuario("admin","admin","coreo1"));
        lista.add(new Usuario("Manu","1234","coreo2"));
        return lista;
    }

    public Usuario getUsuario(Usuario usuario){
        if(DAOUsuario.getInstance().getLista().contains(usuario)){
            return usuario;
        }
        else return null;
    }
    public Boolean agregarUsuario(Usuario usuario){
        if(DAOUsuario.getInstance().getUsuario(usuario)==null){
            lista.add(usuario);
            return true;
        }

        return false;
    }

}
