package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.Configuracion.Configuracion;
import com.example.pizzeria.MenuPrincipal;
import com.example.pizzeria.R;
import com.example.pizzeria.databinding.ActivityMenuPedidoBinding;
import com.example.pizzeria.databinding.ActivityMenuPrincipalBinding;

public class MenuPedido extends AppCompatActivity implements View.OnClickListener {

    private ActivityMenuPedidoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMenuPedidoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        binding.btnPedirFavorito.setOnClickListener(this);
        binding.btnPersonalizado.setOnClickListener(this);
        binding.btnPredeterminado.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnPedirFavorito){
            Intent i = new Intent(MenuPedido.this, Carrito.class);
            startActivity(i);
        }
        if(view.getId()==R.id.btnPersonalizado){
            Intent i = new Intent(MenuPedido.this, PedidoTipoKebab.class);
            startActivity(i);
        }
        if(view.getId()==R.id.btnPredeterminado){
            Intent i = new Intent(MenuPedido.this, PedidoPredeterminado.class);
            startActivity(i);
        }
    }
}