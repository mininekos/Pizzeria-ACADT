package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pizzeria.ActivitysPedido.MenuPedido;
import com.example.pizzeria.ActivitysPedido.PedidoTipoKebab;
import com.example.pizzeria.Configuracion.Configuracion;
import com.example.pizzeria.databinding.ActivityMenuPrincipalBinding;

public class MenuPrincipal extends AppCompatActivity implements View.OnClickListener {

    private ActivityMenuPrincipalBinding binding;
    private SharedPreferences preferencias;
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
        binding.btnLlamar.setOnClickListener(this);
        preferencias=getSharedPreferences("Todo", Context.MODE_PRIVATE);
        binding.txtUsuarioRegistrado.setText(preferencias.getString("NombreUsuario"," "));

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
        if(view.getId()==R.id.btnLlamar){
            Intent i = new Intent(Intent.ACTION_DIAL);
            i.setData(Uri.parse("tel:643740622"));
            startActivity(i);
        }
    }

    private AlertDialog.Builder crearDialogo() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Salir");
        dialogo1.setMessage("¿Quieres salir?");
        dialogo1.setCancelable(true);

        dialogo1.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
                System.exit(0);
            }
        });

        dialogo1.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return dialogo1;
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialogo = crearDialogo();
        dialogo.show();
    }
}