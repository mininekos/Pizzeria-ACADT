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
        if(lista==null)
            lista=new ArrayList<Kebab>();
        return dao;
    }

    public ArrayList<Kebab> getLista(){

        ArrayList<TipoIngredientes> ingredientesFeta=new ArrayList<TipoIngredientes>();
        ingredientesFeta.add(TipoIngredientes.LECHUGA);
        ingredientesFeta.add(TipoIngredientes.TOMATE);
        ingredientesFeta.add(TipoIngredientes.MAIZ);
        ingredientesFeta.add(TipoIngredientes.CEBOLLA);
        ingredientesFeta.add(TipoIngredientes.COL);
        ingredientesFeta.add(TipoIngredientes.QUESO_FETA);

        ArrayList<TipoIngredientes> ingredientesCompletoVerduras=new ArrayList<TipoIngredientes>();
        ingredientesFeta.add(TipoIngredientes.LECHUGA);
        ingredientesFeta.add(TipoIngredientes.TOMATE);
        ingredientesFeta.add(TipoIngredientes.MAIZ);
        ingredientesFeta.add(TipoIngredientes.CEBOLLA);
        ingredientesFeta.add(TipoIngredientes.COL);
        ingredientesFeta.add(TipoIngredientes.ACEITUNAS);
        ingredientesFeta.add(TipoIngredientes.QUESO_FETA);

        ArrayList<TipoIngredientes> ingredientesSoloCarnePatatas=new ArrayList<TipoIngredientes>();
        ingredientesFeta.add(TipoIngredientes.EXTRA_CARNE);
        ingredientesFeta.add(TipoIngredientes.PATATAS);

        ArrayList<TipoIngredientes> ingredientesSuperCompleto=new ArrayList<TipoIngredientes>();
        ingredientesFeta.add(TipoIngredientes.LECHUGA);
        ingredientesFeta.add(TipoIngredientes.TOMATE);
        ingredientesFeta.add(TipoIngredientes.MAIZ);
        ingredientesFeta.add(TipoIngredientes.CEBOLLA);
        ingredientesFeta.add(TipoIngredientes.COL);
        ingredientesFeta.add(TipoIngredientes.ACEITUNAS);
        ingredientesFeta.add(TipoIngredientes.QUESO_FETA);
        ingredientesFeta.add(TipoIngredientes.EXTRA_CARNE);
        ingredientesFeta.add(TipoIngredientes.HUEVO);
        ingredientesFeta.add(TipoIngredientes.PATATAS);

        lista.add(new Kebab("Completo",ingredientesCompletoVerduras, TipoKebab.LAHMACUM, TipoCarne.MIXTO, TipoSalsa.AMBAS));
        lista.add(new Kebab("SuperCompleto",ingredientesSuperCompleto, TipoKebab.LAHMACUM, TipoCarne.MIXTO, TipoSalsa.AMBAS));
        lista.add(new Kebab("Carnivoro",ingredientesSoloCarnePatatas, TipoKebab.LAHMACUM, TipoCarne.MIXTO, TipoSalsa.AMBAS));
        lista.add(new Kebab("Feta",ingredientesFeta, TipoKebab.LAHMACUM, TipoCarne.MIXTO, TipoSalsa.AMBAS));

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
