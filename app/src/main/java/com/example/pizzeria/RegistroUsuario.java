package com.example.pizzeria;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Service;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.Recursos.Usuario;
import com.example.pizzeria.Servicio.Servicio;
import com.example.pizzeria.databinding.ActivityRegistroUsuarioBinding;

public class RegistroUsuario extends AppCompatActivity implements View.OnClickListener {

    private ActivityRegistroUsuarioBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityRegistroUsuarioBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        getSupportActionBar().hide();
        setContentView(view);
        binding.btnVolverRegistro.setOnClickListener(this);
        binding.btnRegistrar.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnVolverRegistro){
            finish();
        }
        if(view.getId()==R.id.btnRegistrar){
            registrar();
        }
    }

    private void registrar() {
        if(binding.txtEmail.getText().toString().equals("")){
            crearDialogo("Email no introducido").show();
        }
        else if(binding.txtUsuarioRegistro.getText().toString().equals("")){
            crearDialogo("Usuario no introducido").show();
        }
        else if(binding.txtContrasennaRegistro.getText().toString().equals("")){
            crearDialogo("Contraseña no introducido").show();
        }
        else{
            Usuario usuarioRegistro = new Usuario(binding.txtUsuarioRegistro.getText().toString(),
                    binding.txtContrasennaRegistro.getText().toString(),
                    binding.txtEmail.getText().toString());
            if(Servicio.getServicio().obtenerUsuario(usuarioRegistro) != null){
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                dialogo1.setTitle("Error");
                dialogo1.setMessage("Usuario ya registrado");
                dialogo1.setCancelable(false);

                dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                dialogo1.show();
            }
            else {
                Servicio.getServicio().agregarUsuario(usuarioRegistro);
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
                dialogo1.setTitle("Correcto");
                dialogo1.setMessage("Usuario registrado correctamente");
                dialogo1.setCancelable(false);

                dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
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

    @Override
    public void onBackPressed() {
        finish();
    }
}