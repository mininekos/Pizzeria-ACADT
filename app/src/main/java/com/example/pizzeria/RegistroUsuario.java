package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.databinding.ActivityRegistroUsuarioBinding;

public class RegistroUsuario extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegistroUsuarioBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistroUsuarioBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        binding.btnVolverRegistro.setOnClickListener(this);
        binding.btnRegistrar.setOnClickListener(this);
        setContentView(view);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnVolverRegistro){
            finish();
        }
        if(view.getId()==R.id.btnRegistrar){
            finish();
        }
    }
}