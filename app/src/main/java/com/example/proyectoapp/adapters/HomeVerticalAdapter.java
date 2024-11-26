package com.example.proyectoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapp.R;
import com.example.proyectoapp.models.HomeVerticalModel;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.ViewHolder> {

    Context context;
    AbstractList<HomeVerticalModel> list;

    public HomeVerticalAdapter(Context context, ArrayList<HomeVerticalModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.deslizar_abajo_home,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImagen());
        holder.nombre.setText(list.get(position).getNombre());
        holder.temporizador.setText(list.get(position).getTemporizador());
        holder.precio.setText(list.get(position).getPrecio());
        holder.rating.setText(list.get(position).getRating());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nombre,temporizador,rating,precio;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ver_img);
            nombre = itemView.findViewById(R.id.nombre);
            temporizador = itemView.findViewById(R.id.temporizador);
            rating = itemView.findViewById(R.id.rating1);
            precio = itemView.findViewById(R.id.precio);
        }
    }
}
