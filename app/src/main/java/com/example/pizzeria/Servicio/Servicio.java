package com.example.pizzeria.Servicio;

import com.example.pizzeria.ConexionBD.DBHelper;
import com.example.pizzeria.DAOS.DAOKebab;
import com.example.pizzeria.DAOS.DAOKebabPredeterminados;
import com.example.pizzeria.DAOS.DAOUsuario;
import com.example.pizzeria.Enums.TipoIngredientes;
import com.example.pizzeria.Recursos.Kebab;
import com.example.pizzeria.Recursos.Usuario;

import java.util.ArrayList;

public class Servicio {


    private static Servicio servicio;
    private Usuario usuarioRegistrado;
    private DBHelper dbHelper;
    public Servicio() {
    }

    public static Servicio getServicio(){

        if(servicio==null){
            servicio=new Servicio();
        }
        return servicio;
    }

    public Usuario getUsuarioRegistrado() {
        return usuarioRegistrado;
    }

    public void setDbHelper(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
        DAOUsuario.getInstance().setDbHelper(dbHelper);
        DAOKebab.getInstance().setDbHelper(dbHelper);
    }

    public void setUsuarioRegistrado(Usuario usuarioRegistrado) {
        this.usuarioRegistrado = usuarioRegistrado;
    }

    public Boolean obtenerUsuario(Usuario usuario){
        return dbHelper.buscarUsuario(usuario);
    }

    public Kebab obtenerKebab(Kebab kebab){
        return DAOKebab.getInstance().getKebab(kebab);
    }

    public Boolean agregarUsuario(Usuario usuario){
        dbHelper.insertarUsuario(usuario);
        return true;
        //return DAOUsuario.getInstance().agregarUsuario(usuario);
    }

    public Boolean agregarKebab(Kebab kebab,String usuario){
        dbHelper.insertarKebab(kebab, usuario);
        int idKebab=dbHelper.idKebab();
        for (TipoIngredientes ingrediente: kebab.getIngredientes()) {
            dbHelper.insertarIgrediente(ingrediente.ordinal(),idKebab);
        }
        //return DAOKebab.getInstance().agregarKebab(kebab,usuario);
        return true;
    }

    public Kebab obtenerFavorito(){
        for (int ind=0;ind<DAOKebab.getInstance().getSizeLista();ind++){
            if(DAOKebab.getInstance().getLista().get(ind).getFavorito()==true) {
                return DAOKebab.getInstance().getLista().get(ind);
            }
        }
        return null;
    }

    public Kebab obtnerFavoritoDB(){
        ArrayList<Kebab> lista= dbHelper.obtnerKebabs();
        for(int ind=0;ind< lista.size();ind++){
            if(lista.get(ind).getFavorito()==true)
                return lista.get(ind);
        }

        return null;
    }

    public Boolean limpiarFavorito(String usuario){
        dbHelper.limpiarFavorito(usuario);
        //return DAOKebab.getInstance().eleminarFavorito(usuario);
        return true;
    }

    public Boolean ponerFavirito(){
        DAOKebab.getInstance().getLista().get(DAOKebab.getInstance().getSizeLista()-1).setFavorito(true);
        return true;
    }

    public Boolean ponerFavoritoDB(){
        dbHelper.ponerFavorito(dbHelper.idKebab());
        return true;
    }

    public ArrayList<Kebab> obtenerListaKebabPredeterminado(){
        return DAOKebabPredeterminados.getInstance().getLista();
    }

    public Kebab obtnerKebabFavoritoDB(){

        return dbHelper.obtnerKebabFavorito(usuarioRegistrado);
    }

}
