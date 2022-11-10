package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.MenuPrincipal;
import com.example.pizzeria.R;
import com.example.pizzeria.databinding.ActivityPedidoIngredientesBinding;

public class PedidoIngredientes extends AppCompatActivity implements View.OnClickListener {

    private ActivityPedidoIngredientesBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding=ActivityPedidoIngredientesBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        binding.btnVolverIngredientes.setOnClickListener(this);
        binding.btnIrCarritoIngredientes.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.btnIrCarritoIngredientes){
            Intent i = new Intent(PedidoIngredientes.this, Carrito.class);
            startActivity(i);
        }
        if(view.getId()== R.id.btnVolverIngredientes){
            finish();
        }
    }
}