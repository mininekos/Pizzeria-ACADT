package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.Configuracion.Configuracion;
import com.example.pizzeria.MenuPrincipal;
import com.example.pizzeria.R;
import com.example.pizzeria.Recursos.Kebab;
import com.example.pizzeria.Servicio.Servicio;
import com.example.pizzeria.databinding.ActivityMenuPedidoBinding;
import com.example.pizzeria.databinding.ActivityMenuPrincipalBinding;

public class MenuPedido extends AppCompatActivity implements View.OnClickListener {

    private ActivityMenuPedidoBinding binding;
    private SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMenuPedidoBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getSupportActionBar().hide();
        binding.btnPedirFavorito.setOnClickListener(this);
        binding.btnPersonalizado.setOnClickListener(this);
        binding.btnPredeterminado.setOnClickListener(this);
        preferencias=getSharedPreferences("Todo", Context.MODE_PRIVATE);
        binding.txtUsuarioRegistradoPedido.setText(preferencias.getString("NombreUsuario"," "));


    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.btnPedirFavorito){
            favorito();
        }
        if(view.getId()==R.id.btnPersonalizado){
            Intent i = new Intent(MenuPedido.this, PedidoTipoKebab.class);
            startActivity(i);
        }
        if(view.getId()==R.id.btnPredeterminado){
            Intent i = new Intent(MenuPedido.this, PedidoPredeterminado.class);
            startActivity(i);
        }
    }

    private void favorito() {
        if(preferencias.getBoolean("Favorito",true)){
            Kebab kebab= Servicio.getServicio().obtnerKebabFavoritoDB();
            Intent i = new Intent(MenuPedido.this, Carrito.class);
            i.putExtra("Kebab",kebab);
            startActivity(i);
        }
        else{
            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(this);
            dialogo1.setTitle("Error");
            dialogo1.setMessage("Favorito no seleecionado");
            dialogo1.setCancelable(true);

            dialogo1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            dialogo1.show();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}