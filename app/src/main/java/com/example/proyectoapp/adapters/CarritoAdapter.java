package com.example.proyectoapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapp.R;
import com.example.proyectoapp.models.CarritoModel;
import com.example.proyectoapp.models.HomeHorizontalModel;

import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.ViewHolder> {

    List<CarritoModel> list;

    public CarritoAdapter(List<CarritoModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.carrito_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(list.get(position).getImagen());
        holder.nombre.setText(list.get(position).getNombre());
        holder.rating.setText(list.get(position).getRating());
        holder.precio.setText(list.get(position).getPrecio());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView nombre, rating, precio;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.detailed_img);
            nombre = itemView.findViewById(R.id.detailed_name);
            rating = itemView.findViewById(R.id.detailed_rating);
            precio = itemView.findViewById(R.id.textView7);
        }
    }
}
