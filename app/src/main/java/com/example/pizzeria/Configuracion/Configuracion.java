package com.example.pizzeria.Configuracion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import com.example.pizzeria.R;

public class Configuracion extends AppCompatActivity {
    private Spinner colores;
    private ArrayAdapter adapter;
    private String[] opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        colores=(Spinner) findViewById(R.id.spinnerColores);
        opciones= new String[]{"Blanco","Amarillo","Azul","Naraja","Rosa"};
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opciones);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        colores.setAdapter(adapter);
    }
}