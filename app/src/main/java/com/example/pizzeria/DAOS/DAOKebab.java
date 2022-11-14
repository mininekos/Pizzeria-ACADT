package com.example.pizzeria.DAOS;

import com.example.pizzeria.Recursos.Kebab;

import java.util.ArrayList;

public class DAOKebab {

    private static ArrayList<Kebab> lista;
    private static DAOKebab dao;

    public static DAOKebab getInstance(){

        if (dao==null)
            dao=new DAOKebab();
        if(lista==null)
            lista=new ArrayList<Kebab>();
        return dao;
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
    public Boolean agregarKebab(Kebab kebab){
        lista.add(kebab);
        return true;
    }

    public Boolean eliminarultimoKebab(){
        lista.remove(lista.size()-1);
        return true;
    }

    public int getSizeLista(){
        return lista.size();
    }

    public boolean eleminarFavorito(){
        for(int ind=0;ind<lista.size();ind++){
            lista.get(ind).setFavorito(false);
        }
         return true;
    }
}
