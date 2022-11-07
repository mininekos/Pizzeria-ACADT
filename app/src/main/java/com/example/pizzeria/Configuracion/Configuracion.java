package com.example.pizzeria.Configuracion;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.pizzeria.ActivitysPedido.PedidoTipoKebab;
import com.example.pizzeria.MenuPrincipal;
import com.example.pizzeria.R;
import com.example.pizzeria.databinding.ActivityConfiguracionBinding;
import com.example.pizzeria.databinding.ActivityInicioSesionBinding;

public class Configuracion extends AppCompatActivity implements View.OnClickListener {
    private Spinner colores;
    private ArrayAdapter adapter;
    private String[] opciones;
    private ActivityConfiguracionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfiguracionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();

        colores=(Spinner) findViewById(R.id.spinnerColores);
        opciones= new String[]{"Blanco","Amarillo","Azul","Naraja","Rosa"};
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colores.setAdapter(adapter);
        binding.btnVolverConfiguracion.setOnClickListener(this);
        binding.btnGuardarConfiguracion.setOnClickListener(this);
        setContentView(view);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnVolverConfiguracion){
            finish();
        }
        if(view.getId()==R.id.btnGuardarConfiguracion){
            finish();
        }
    }
}