package com.example.pizzeria.DAOS;

import com.example.pizzeria.ConexionBD.DBHelper;
import com.example.pizzeria.Enums.TipoIngredientes;
import com.example.pizzeria.Recursos.Kebab;

import java.util.ArrayList;

public class DAOKebab {

    private static ArrayList<Kebab> lista;
    private static DAOKebab dao;
    private DBHelper dbHelper;

    public static DAOKebab getInstance(){

        if (dao==null)
            dao=new DAOKebab();
        if(lista==null)
            lista=new ArrayList<Kebab>();
        return dao;
    }

    public void setDbHelper(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    public ArrayList<Kebab> getLista(){
        return lista;
    }

    public Kebab getKebab(Kebab kebab){
        if(DAOKebab.getInstance().getLista().contains(kebab)){
            return kebab;
        }
        else return null;
    }
    public Boolean agregarKebab(Kebab kebab,String usuario){
        lista.add(kebab);
        dbHelper.insertarKebab(kebab, usuario);
        int idKebab=dbHelper.idKebab();
        for (TipoIngredientes ingrediente: kebab.getIngredientes()) {
            dbHelper.insertarIgrediente(ingrediente.ordinal(),idKebab);
        }

        return true;
    }

    public Boolean eliminarultimoKebab(){
        lista.remove(lista.size()-1);
        return true;
    }

    public int getSizeLista(){
        return lista.size();
    }

    public boolean eleminarFavorito(String usuario){
        dbHelper.limpiarFavorito(usuario);
        for(int ind=0;ind<lista.size();ind++){
            lista.get(ind).setFavorito(false);
        }
         return true;
    }
}
