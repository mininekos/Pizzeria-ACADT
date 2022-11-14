package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;


import com.example.pizzeria.R;
import com.example.pizzeria.Recursos.Kebab;
import com.example.pizzeria.Servicio.Servicio;
import com.example.pizzeria.databinding.ActivityPedidoPredeterminadoBinding;

import java.util.ArrayList;


public class PedidoPredeterminado extends AppCompatActivity implements View.OnClickListener {

    private ActivityPedidoPredeterminadoBinding binding;
    private SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPedidoPredeterminadoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        preferencias=getSharedPreferences("Todo", Context.MODE_PRIVATE);
        binding.txtUsuarioRegistradoPredeterminado.setText(preferencias.getString("NombreUsuario"," "));
        cargarLista();
        binding.btnVolverPredeterminado.setOnClickListener(this);
    }

    private void cargarLista() {
        ArrayList<String> lista = new ArrayList<>();
        for (Kebab kb: Servicio.getServicio().obtenerListaKebabPredeterminado()) {
            lista.add(kb.getNombre());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,lista);
        binding.listaKebabsPredeterminados.setAdapter(adapter);

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