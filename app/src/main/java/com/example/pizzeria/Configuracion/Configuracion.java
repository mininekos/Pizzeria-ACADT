package com.example.pizzeria.Configuracion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.pizzeria.R;

public class Configuracion extends AppCompatActivity {
    private Spinner colores;
    private Adapter adapter;
    private String[] opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);
        colores=findViewById(R.id.spinnerColores);
        opciones= new String[]{"Escoja color: ", "Blanco","Amarillo","Azul","Naraja","Rosa"};
        adapter= new ArrayAdapter<String>(this,R.layout.activity_configuracion,opciones);
    }
}