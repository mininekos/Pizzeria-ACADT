package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.Pedido.PedidoTipoKebab;
import com.example.pizzeria.databinding.ActivityInicioSesionBinding;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {

    private ActivityInicioSesionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInicioSesionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        binding.btnIniciarSesion.setOnClickListener(this);
        setContentView(R.layout.activity_inicio_sesion);
    }


    @Override
    public void onClick(View view) {
        if(R.id.btnIniciarSesion==view.getId()){
            Intent i = new Intent(this, PedidoTipoKebab.class);
            startActivity(i);
        }
    }
}