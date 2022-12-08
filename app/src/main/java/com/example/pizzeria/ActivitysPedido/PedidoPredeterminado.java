package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;


import com.example.pizzeria.DAOS.DAOKebab;
import com.example.pizzeria.DAOS.DAOKebabPredeterminados;
import com.example.pizzeria.R;
import com.example.pizzeria.Recursos.Kebab;
import com.example.pizzeria.Servicio.Servicio;
import com.example.pizzeria.databinding.ActivityPedidoPredeterminadoBinding;

import java.util.ArrayList;


public class PedidoPredeterminado extends AppCompatActivity implements View.OnClickListener {

    private ActivityPedidoPredeterminadoBinding binding;
    private SharedPreferences preferencias;
    private ArrayList<Kebab> listaKebabPred;
    private AdapterDatos adapterDatos;
    private LinearLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        listaKebabPred= DAOKebabPredeterminados.getInstance().getLista();
        binding=ActivityPedidoPredeterminadoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        preferencias=getSharedPreferences("Todo", Context.MODE_PRIVATE);
        binding.txtUsuarioRegistradoPredeterminado.setText(preferencias.getString("NombreUsuario"," "));
        binding.btnVolverPredeterminado.setOnClickListener(this);
        layoutManager = new LinearLayoutManager(this);
        binding.recicleViewKebabs.setLayoutManager(layoutManager);
        adapterDatos = new AdapterDatos(this);
        binding.recicleViewKebabs.setAdapter(adapterDatos);
        cargarLista();

    }

    private void cargarLista() {
        ArrayList<String> lista = new ArrayList<>();

        for (Kebab kb: Servicio.getServicio().obtenerListaKebabPredeterminado()) {
            lista.add(kb.getNombre());
        }

        adapterDatos.add(new Item(getDrawable(R.drawable.durum),lista.get(0)));
        adapterDatos.add(new Item(getDrawable(R.drawable.durum),lista.get(1)));
        adapterDatos.add(new Item(getDrawable(R.drawable.durum),lista.get(2)));
        adapterDatos.add(new Item(getDrawable(R.drawable.durum),lista.get(3)));

    }


    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.btnVolverPredeterminado){
            finish();
        }
    }


    @Override
    public void onBackPressed() {
        finish();
    }
}