package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.MenuPrincipal;
import com.example.pizzeria.R;
import com.example.pizzeria.Recursos.Kebab;
import com.example.pizzeria.Servicio.Servicio;
import com.example.pizzeria.databinding.ActivityCarritoBinding;

public class Carrito extends AppCompatActivity implements View.OnClickListener {

    private ActivityCarritoBinding binding;
    private Kebab kebab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCarritoBinding.inflate(getLayoutInflater());
        getSupportActionBar().hide();
        View view= binding.getRoot();
        setContentView(view);
        binding.btnFinalizarCarrito.setOnClickListener(this);
        binding.btnVolverCarrito.setOnClickListener(this);
        binding.btnFavorito.setOnClickListener(this);
        kebab=(Kebab) getIntent().getSerializableExtra("Kebab");
        binding.txtPedido.setText(kebab.toString());
        binding.txtPrecio.setText(kebab.obtenerPrecio().toString());

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnFinalizarCarrito){
            Servicio.getServicio().agregarKebab(kebab,Servicio.getServicio().getUsuarioRegistrado().getNombre());
            Intent intent = new Intent(getApplicationContext(), MenuPrincipal.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);

        }
        if(view.getId()==R.id.btnFavorito){
            Servicio.getServicio().limpiarFavorito();
            Servicio.getServicio().agregarKebab(kebab,Servicio.getServicio().getUsuarioRegistrado().getNombre());
            Servicio.getServicio().ponerFavirito();
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