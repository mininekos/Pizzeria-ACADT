package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

    private AlertDialog.Builder crearDialogo(String cadena) {
        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
        dialogo1.setTitle("Rellene los campos");
        dialogo1.setMessage(cadena);
        dialogo1.setCancelable(true);

        dialogo1.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return dialogo1;
    }

    @Override
    public void onClick(View view) {
        if(R.id.btnSiguienteTipoKebab==view.getId()){
            if(binding.radioGridGroup.getCheckedRadioButtonId()==-1){
                AlertDialog.Builder dialogo = crearDialogo("Falta escoger el tipo de kebab");
                dialogo.show();
            }
            else if(binding.rgSalsa.getCheckedRadioButtonId()==-1){
                AlertDialog.Builder dialogo = crearDialogo("Falta escoger salsa");
                dialogo.show();
            }
            else if(binding.rgCarne.getCheckedRadioButtonId()==-1){
                AlertDialog.Builder dialogo = crearDialogo("Falta escoger carne");
                dialogo.show();
            }
            else{
                Intent i = new Intent(PedidoTipoKebab.this, PedidoIngredientes.class);
                startActivity(i);
            }


        }
        if(R.id.btnVolverTipoKebab==view.getId()){
            finish();
        }


    }
}