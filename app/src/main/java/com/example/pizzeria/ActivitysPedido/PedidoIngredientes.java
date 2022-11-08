package com.example.pizzeria.ActivitysPedido;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.pizzeria.R;

public class PedidoIngredientes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_pedido_ingredientes);
    }
}