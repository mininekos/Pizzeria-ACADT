package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;


import com.example.pizzeria.databinding.ActivityPedidoPredeterminadoBinding;


public class PedidoPredeterminado extends AppCompatActivity {

    private ActivityPedidoPredeterminadoBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPedidoPredeterminadoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();

    }


}