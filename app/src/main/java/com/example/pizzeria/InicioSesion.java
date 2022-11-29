package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.ActivitysPedido.PedidoTipoKebab;
import com.example.pizzeria.ConexionBD.DBHelper;
import com.example.pizzeria.Configuracion.Configuracion;
import com.example.pizzeria.Recursos.Usuario;
import com.example.pizzeria.Servicio.Servicio;
import com.example.pizzeria.databinding.ActivityInicioSesionBinding;

public class InicioSesion extends AppCompatActivity implements View.OnClickListener {

    private ActivityInicioSesionBinding binding;
    private SharedPreferences preferencias;
    private SharedPreferences.Editor editor;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInicioSesionBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getSupportActionBar().hide();
        setContentView(view);
        binding.btnIniciarSesion.setOnClickListener(this);
        binding.txtRegistrar.setOnClickListener(this);
        preferencias=getSharedPreferences("Todo", Context.MODE_PRIVATE);
        editor = preferencias.edit();
        editor.putBoolean("Favorito",false);
        editor.commit();
        if(preferencias.getBoolean("Recuerdame",true)){
            binding.txtUsuarioInicio.setText(preferencias.getString("NombreUsuario", " "));
            binding.txtContrasennaInicio.setText(preferencias.getString("ContrasennaUsuario", " "));
            binding.checkRecuerdame.setChecked(true);
        }

        dbHelper=new DBHelper(InicioSesion.this);
        Servicio.getServicio().setDbHelper(dbHelper);
    }


    @Override
    public void onClick(View view) {
        if(R.id.btnIniciarSesion==view.getId()){
            iniciarSesion();
        }
        if(R.id.txtRegistrar==view.getId()){
            Intent i = new Intent(InicioSesion.this, RegistroUsuario.class);
            startActivity(i);
        }
    }
    public void iniciarSesion(){

        if (binding.txtUsuarioInicio.getText().toString().equals("")){
            crearDialogo("Usuario no introducido").show();
        }
        else if (binding.txtContrasennaInicio.getText().toString().equals("")){
            crearDialogo("Contraseña no introducida").show();
        }
        else {
            Usuario usuarioInicio= new Usuario(binding.txtUsuarioInicio.getText().toString(),binding.txtContrasennaInicio.getText().toString());

            if (Servicio.getServicio().obtenerUsuario(usuarioInicio) == true) {
                Servicio.getServicio().setUsuarioRegistrado(usuarioInicio);
                editor.putString("NombreUsuario",binding.txtUsuarioInicio.getText().toString());
                editor.putString("ContrasennaUsuario",binding.txtContrasennaInicio.getText().toString());
                editor.commit();
                if(binding.checkRecuerdame.isChecked()){
                    editor.putBoolean("Recuerdame",true);
                    editor.commit();
                }
                else{
                    editor.putBoolean("Recuerdame",false);
                    editor.commit();
                }
                Intent i = new Intent(InicioSesion.this, MenuPrincipal.class);

                startActivity(i);
            } else {
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                dialogo1.setTitle("Error");
                dialogo1.setMessage("Usuario no registrado");
                dialogo1.setCancelable(true);

                dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialogo1.show();
            }
        }

    }
    private AlertDialog.Builder crearDialogo(String cadena) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Rellene los campos");
        dialogo1.setMessage(cadena);
        dialogo1.setCancelable(true);

        dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return dialogo1;
    }
    private AlertDialog.Builder crearDialogo() {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Cerrar");
        dialogo1.setMessage("Desea cerrar la aplicacion");
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
        crearDialogo().show();
    }
}