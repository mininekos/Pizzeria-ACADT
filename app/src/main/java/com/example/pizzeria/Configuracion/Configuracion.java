package com.example.pizzeria.Configuracion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.pizzeria.ActivitysPedido.PedidoTipoKebab;
import com.example.pizzeria.MenuPrincipal;
import com.example.pizzeria.R;
import com.example.pizzeria.Servicio.Servicio;
import com.example.pizzeria.databinding.ActivityConfiguracionBinding;
import com.example.pizzeria.databinding.ActivityInicioSesionBinding;

public class Configuracion extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private Spinner colores;
    private ArrayAdapter adapter;
    private String[] opciones;
    private ActivityConfiguracionBinding binding;
    private SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConfiguracionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        colores=(Spinner) findViewById(R.id.spinnerColores);
        opciones= new String[]{"Blanco","Azul","Naraja","Rosa"};
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colores.setAdapter(adapter);
        binding.btnVolverConfiguracion.setOnClickListener(this);
        binding.btnGuardarConfiguracion.setOnClickListener(this);
        binding.switchFavorito.setOnCheckedChangeListener(this);
        preferencias=getSharedPreferences("Todo", Context.MODE_PRIVATE);

    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnVolverConfiguracion){
            finish();
        }
        if(view.getId()==R.id.btnGuardarConfiguracion){
            guardar();
            finish();
        }
    }

    private void guardar() {

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        SharedPreferences.Editor editor = preferencias.edit();

        if(b==true){
            if(Servicio.getServicio().obtnerKebabFavoritoDB()==null){
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                dialogo1.setTitle("Error");
                dialogo1.setMessage("No hay kebab favorito");
                dialogo1.setCancelable(true);

                dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogo1.show();
                binding.switchFavorito.setChecked(false);
            }
            else{
                editor.putBoolean("Favorito",b);
                editor.commit();
            }
        }
        else{
            editor.putBoolean("Favorito",b);
            editor.commit();
        }
    }
}