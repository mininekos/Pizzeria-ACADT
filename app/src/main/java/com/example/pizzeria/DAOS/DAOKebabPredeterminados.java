package com.example.pizzeria.DAOS;

import com.example.pizzeria.Enums.TipoCarne;
import com.example.pizzeria.Enums.TipoIngredientes;
import com.example.pizzeria.Enums.TipoKebab;
import com.example.pizzeria.Enums.TipoSalsa;
import com.example.pizzeria.Recursos.Kebab;

import java.util.ArrayList;

public class DAOKebabPredeterminados {

    private static ArrayList<Kebab> lista;
    private static DAOKebabPredeterminados dao;

    public static DAOKebabPredeterminados getInstance(){

        if (dao==null)
            dao=new DAOKebabPredeterminados();
        if (lista==null)
            lista=new ArrayList<Kebab>();
        return dao;
    }

    public ArrayList<Kebab> getLista(){

        if(lista.size()==0) {
            ArrayList<TipoIngredientes> ingredientesFeta = new ArrayList<TipoIngredientes>();
            ingredientesFeta.add(TipoIngredientes.LECHUGA);
            ingredientesFeta.add(TipoIngredientes.TOMATE);
            ingredientesFeta.add(TipoIngredientes.MAIZ);
            ingredientesFeta.add(TipoIngredientes.CEBOLLA);
            ingredientesFeta.add(TipoIngredientes.COL);
            ingredientesFeta.add(TipoIngredientes.QUESO_FETA);

            ArrayList<TipoIngredientes> ingredientesCompletoVerduras = new ArrayList<TipoIngredientes>();
            ingredientesCompletoVerduras.add(TipoIngredientes.LECHUGA);
            ingredientesCompletoVerduras.add(TipoIngredientes.TOMATE);
            ingredientesCompletoVerduras.add(TipoIngredientes.MAIZ);
            ingredientesCompletoVerduras.add(TipoIngredientes.CEBOLLA);
            ingredientesCompletoVerduras.add(TipoIngredientes.COL);
            ingredientesCompletoVerduras.add(TipoIngredientes.ACEITUNAS);
            ingredientesCompletoVerduras.add(TipoIngredientes.QUESO_FETA);

            ArrayList<TipoIngredientes> ingredientesSoloCarnePatatas = new ArrayList<TipoIngredientes>();
            ingredientesSoloCarnePatatas.add(TipoIngredientes.EXTRA_CARNE);
            ingredientesSoloCarnePatatas.add(TipoIngredientes.PATATAS);

            ArrayList<TipoIngredientes> ingredientesSuperCompleto = new ArrayList<TipoIngredientes>();
            ingredientesSuperCompleto.add(TipoIngredientes.LECHUGA);
            ingredientesSuperCompleto.add(TipoIngredientes.TOMATE);
            ingredientesSuperCompleto.add(TipoIngredientes.MAIZ);
            ingredientesSuperCompleto.add(TipoIngredientes.CEBOLLA);
            ingredientesSuperCompleto.add(TipoIngredientes.COL);
            ingredientesSuperCompleto.add(TipoIngredientes.ACEITUNAS);
            ingredientesSuperCompleto.add(TipoIngredientes.QUESO_FETA);
            ingredientesSuperCompleto.add(TipoIngredientes.EXTRA_CARNE);
            ingredientesSuperCompleto.add(TipoIngredientes.HUEVO);
            ingredientesSuperCompleto.add(TipoIngredientes.PATATAS);

            lista.add(new Kebab("Completo", ingredientesCompletoVerduras, TipoKebab.LAHMACUM, TipoCarne.MIXTO, TipoSalsa.AMBAS));
            lista.add(new Kebab("SuperCompleto", ingredientesSuperCompleto, TipoKebab.LAHMACUM, TipoCarne.MIXTO, TipoSalsa.AMBAS));
            lista.add(new Kebab("Carnivoro", ingredientesSoloCarnePatatas, TipoKebab.LAHMACUM, TipoCarne.MIXTO, TipoSalsa.AMBAS));
            lista.add(new Kebab("Feta", ingredientesFeta, TipoKebab.LAHMACUM, TipoCarne.MIXTO, TipoSalsa.AMBAS));
        }
        return lista;
    }

    public Kebab getKebab(Kebab kebab){
        if(DAOKebabPredeterminados.getInstance().getLista().contains(kebab)){
            return kebab;
        }
        else return null;
    }
    public Boolean agregarKebab(Kebab kebab){
        if (DAOKebabPredeterminados.getInstance().getKebab(kebab)==null) {
            lista.add(kebab);
            return true;
        }
        return false;
    }

}
