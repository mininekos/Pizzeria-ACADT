package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.ActivitysPedido.PedidoTipoKebab;
import com.example.pizzeria.Configuracion.Configuracion;
import com.example.pizzeria.databinding.ActivityInicioSesionBinding;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {

    private ActivityInicioSesionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInicioSesionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getSupportActionBar().hide();
        setContentView(view);
        binding.btnIniciarSesion.setOnClickListener(this);
        binding.txtRegistrar.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(R.id.btnIniciarSesion==view.getId()){
            Intent i = new Intent(InicioSesion.this, MenuPrincipal.class);
            startActivity(i);
        }
        if(R.id.txtRegistrar==view.getId()){
            Intent i = new Intent(InicioSesion.this, RegistroUsuario.class);
            startActivity(i);
        }
    }
}