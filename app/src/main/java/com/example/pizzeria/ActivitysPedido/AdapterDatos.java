package com.example.pizzeria.ActivitysPedido;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pizzeria.DAOS.DAOKebabPredeterminados;
import com.example.pizzeria.R;
import com.example.pizzeria.Recursos.Kebab;

import java.util.ArrayList;
import java.util.List;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolder>{

    private List mDataset;
    private Context context;
    private ArrayList<Kebab> listaKebabPred;
    private int selectedIndex;

    public AdapterDatos(Context context) {
        this.context = context;
        mDataset = new ArrayList();
        listaKebabPred= DAOKebabPredeterminados.getInstance().getLista();
    }

    public void add(Item i){
        mDataset.add(i);
        notifyItemInserted(mDataset.indexOf(i));
    }
    @NonNull
    @Override
    public AdapterDatos.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolder holder, int position) {
        final Item item = (Item) mDataset.get(position);
        holder.imagen.setImageDrawable(item.getImagenKebab());
        holder.nombre.setText(item.getNombreKebab());

        //Podemos asignar eventos a los componentes del viewHolder
        holder.nombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,Carrito.class);
                Kebab kebab = listaKebabPred.get(position);
                intent.putExtra("Kebab",kebab);
                context.startActivity(intent);

            }
        });
        holder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context,Carrito.class);
                Kebab kebab = listaKebabPred.get(position);
                intent.putExtra("Kebab",kebab);
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView imagen;
        protected TextView nombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen=(ImageView) itemView.findViewById(R.id.imagenLista);
            nombre=(TextView) itemView.findViewById(R.id.textoLista);
        }
    }
}
