package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.InicioSesion;
import com.example.pizzeria.MenuPrincipal;
import com.example.pizzeria.R;
import com.example.pizzeria.RegistroUsuario;
import com.example.pizzeria.databinding.ActivityInicioSesionBinding;
import com.example.pizzeria.databinding.ActivityPedidoTipoKebabBinding;

public class PedidoTipoKebab extends AppCompatActivity implements View.OnClickListener {

    private ActivityPedidoTipoKebabBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPedidoTipoKebabBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getSupportActionBar().hide();
        setContentView(view);
        binding.btnSiguienteTipoKebab.setOnClickListener(this);
        binding.btnVolverTipoKebab.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(R.id.btnSiguienteTipoKebab==view.getId()){
            if(binding.radioGridGroup.getCheckedRadioButtonId()==-1){

            }
            else if(binding.rgSalsa.getCheckedRadioButtonId()==-1){

            }
            else if(binding.rgCarne.getCheckedRadioButtonId()==-1){

            }
            else{
                Intent i = new Intent(PedidoTipoKebab.this, MenuPrincipal.class);
                startActivity(i);
            }


        }
        if(R.id.btnVolverTipoKebab==view.getId()){
            finish();
        }
    }
}