package com.example.pizzeria.DAOS;

import com.example.pizzeria.ConexionBD.DBHelper;
import com.example.pizzeria.Recursos.Usuario;

import java.util.ArrayList;

public class DAOUsuario {

    private static ArrayList<Usuario> lista;
    private static DAOUsuario dao;
    private DBHelper dbHelper;

    public static DAOUsuario getInstance(){

        if (dao==null)
            dao=new DAOUsuario();
        if(lista==null)
            lista=new ArrayList<Usuario>();
        return dao;
    }

    public void setDbHelper(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public ArrayList<Usuario> getLista(){
        if(lista.size()==0) {
            lista.add(new Usuario("admin", "admin", "correo1"));
            lista.add(new Usuario("Manu", "1234", "correo2"));
        }
        return lista;
    }

    public Usuario getUsuario(Usuario usuario){
        if(DAOUsuario.getInstance().getLista().contains(usuario)){
            return usuario;
        }
        else return null;
    }
    public Boolean agregarUsuario(Usuario usuario){
        dbHelper.insertarUsuario(usuario);
        if(DAOUsuario.getInstance().getUsuario(usuario)==null){
            lista.add(usuario);
            return true;
        }

        return false;
    }

}
