package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.pizzeria.Enums.TipoCarne;
import com.example.pizzeria.Enums.TipoIngredientes;
import com.example.pizzeria.Enums.TipoKebab;
import com.example.pizzeria.Enums.TipoSalsa;
import com.example.pizzeria.R;
import com.example.pizzeria.Recursos.Kebab;
import com.example.pizzeria.Servicio.Servicio;
import com.example.pizzeria.databinding.ActivityPedidoIngredientesBinding;

import java.util.ArrayList;

public class PedidoIngredientes extends AppCompatActivity implements View.OnClickListener {

    private ActivityPedidoIngredientesBinding binding;
    private TipoKebab tipoKebab;
    private TipoCarne tipoCarne;
    private TipoSalsa tipoSalsa;
    private SharedPreferences preferencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        binding=ActivityPedidoIngredientesBinding.inflate(getLayoutInflater());
        View view= binding.getRoot();
        setContentView(view);
        binding.btnVolverIngredientes.setOnClickListener(this);
        binding.btnIrCarritoIngredientes.setOnClickListener(this);
        tipoKebab=(TipoKebab) getIntent().getSerializableExtra("TipoKebab");
        tipoCarne=(TipoCarne) getIntent().getSerializableExtra("TipoCarne");
        tipoSalsa=(TipoSalsa) getIntent().getSerializableExtra("TipoSalsa");
        preferencias=getSharedPreferences("Todo", Context.MODE_PRIVATE);
        binding.txtUsuarioRegistradoIngredientes.setText(preferencias.getString("NombreUsuario"," "));

    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.btnIrCarritoIngredientes){
            irCarrito();

        }
        if(view.getId()== R.id.btnVolverIngredientes){
            finish();
        }
    }

    private void irCarrito() {
        ArrayList<TipoIngredientes> listaIngredientes= new ArrayList<TipoIngredientes>();
        if (binding.cbAceituna.isChecked())
            listaIngredientes.add(TipoIngredientes.ACEITUNAS);
        if (binding.cbCarne.isChecked())
            listaIngredientes.add(TipoIngredientes.EXTRA_CARNE);
        if (binding.cbTomate.isChecked())
            listaIngredientes.add(TipoIngredientes.TOMATE);
        if (binding.cbCebolla.isChecked())
            listaIngredientes.add(TipoIngredientes.CEBOLLA);
        if (binding.cbCol.isChecked())
            listaIngredientes.add(TipoIngredientes.COL);
        if (binding.cbPatatas.isChecked())
            listaIngredientes.add(TipoIngredientes.PATATAS);
        if (binding.cbMozzarrella.isChecked())
            listaIngredientes.add(TipoIngredientes.QUESO_SUAVE);
        if (binding.cbMaiz.isChecked())
            listaIngredientes.add(TipoIngredientes.MAIZ);
        if (binding.cbLechuga.isChecked())
            listaIngredientes.add(TipoIngredientes.LECHUGA);
        if (binding.cbHuevo.isChecked())
            listaIngredientes.add(TipoIngredientes.HUEVO);
        if (binding.cbFeta.isChecked())
            listaIngredientes.add(TipoIngredientes.QUESO_FETA);

        Kebab kebab= new Kebab(listaIngredientes,tipoKebab,tipoCarne,tipoSalsa);
        Servicio.getServicio().agregarKebab(kebab);

        Intent i = new Intent(PedidoIngredientes.this, Carrito.class);
        i.putExtra("Kebab",kebab);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}