package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.ActivitysPedido.MenuPedido;
import com.example.pizzeria.ActivitysPedido.PedidoTipoKebab;
import com.example.pizzeria.Configuracion.Configuracion;
import com.example.pizzeria.databinding.ActivityMenuPrincipalBinding;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {

    private ActivityMenuPrincipalBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMenuPrincipalBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getSupportActionBar().hide();
        setContentView(view);
        binding.btnConfiguracion.setOnClickListener(this);
        binding.btnPedido.setOnClickListener(this);
        binding.btnWeb.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnConfiguracion){
            Intent i = new Intent(MenuPrincipal.this, Configuracion.class);
            startActivity(i);
        }
        if(view.getId()==R.id.btnPedido){
            Intent i = new Intent(MenuPrincipal.this, MenuPedido.class);
            startActivity(i);
        }
        if(view.getId()==R.id.btnWeb){
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("https://saborgourmet.com/kebab-tipico-de-turquia/"));
            startActivity(i);
        }
    }
}