package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.MenuPrincipal;
import com.example.pizzeria.R;
import com.example.pizzeria.databinding.ActivityCarritoBinding;

public class Carrito extends AppCompatActivity implements View.OnClickListener {

    private ActivityCarritoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCarritoBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide();
        View view= binding.getRoot();
        setContentView(view);
        binding.btnFinalizarCarrito.setOnClickListener(this);
        binding.btnVolverCarrito.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnFinalizarCarrito){
            Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        if(view.getId()==R.id.btnVolverCarrito){
            finish();
        }
    }
    @Override
    public void onBackPressed() {
        finish();
    }
}