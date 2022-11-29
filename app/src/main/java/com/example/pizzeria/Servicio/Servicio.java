package com.example.pizzeria.Servicio;

import com.example.pizzeria.ConexionBD.DBHelper;
import com.example.pizzeria.DAOS.DAOKebab;
import com.example.pizzeria.DAOS.DAOKebabPredeterminados;
import com.example.pizzeria.DAOS.DAOUsuario;
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
        return DAOUsuario.getInstance().agregarUsuario(usuario);
    }

    public Boolean agregarKebab(Kebab kebab,String usuario){
        return DAOKebab.getInstance().agregarKebab(kebab,usuario);
    }

    public Kebab obtenerFavorito(){
        for (int ind=0;ind<DAOKebab.getInstance().getSizeLista();ind++){
            if(DAOKebab.getInstance().getLista().get(ind).getFavorito()==true) {
                return DAOKebab.getInstance().getLista().get(ind);
            }
        }
        return null;
    }

    public Boolean limpiarFavorito(){
        return DAOKebab.getInstance().eleminarFavorito();
    }

    public Boolean ponerFavirito(){
        DAOKebab.getInstance().getLista().get(DAOKebab.getInstance().getSizeLista()-1).setFavorito(true);
        return true;
    }

    public ArrayList<Kebab> obtenerListaKebabPredeterminado(){
        return DAOKebabPredeterminados.getInstance().getLista();
    }

    public void ponerFavorito(Kebab kebab){
        DAOKebab.getInstance().getKebab(kebab).setFavorito(true);
    }
}
