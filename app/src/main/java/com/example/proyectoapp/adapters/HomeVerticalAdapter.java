package com.example.proyectoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapp.R;
import com.example.proyectoapp.models.HomeVerticalModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class HomeVerticalAdapter extends RecyclerView.Adapter<HomeVerticalAdapter.ViewHolder> {

    private BottomSheetDialog bottomSheetDialog;
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

        final String mNombre = list.get(position).getNombre();
        final String mTemporizador = list.get(position).getTemporizador();
        final String mRating = list.get(position).getRating();
        final String mPrecio = list.get(position).getPrecio();
        final int mImagen = list.get(position).getImagen();

        holder.imageView.setImageResource(list.get(position).getImagen());
        holder.nombre.setText(list.get(position).getNombre());
        holder.temporizador.setText(list.get(position).getTemporizador());
        holder.rating.setText(list.get(position).getRating());
        holder.precio.setText(list.get(position).getPrecio());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bottomSheetDialog = new BottomSheetDialog(context,R.style.BottomSheetTheme);

                View sheetView = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_layout,null);
                sheetView.findViewById(R.id.agregar_carrito).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,"Agregado al carrito",Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                ImageView bottomImg = sheetView.findViewById(R.id.bottom_img);
                TextView bottomNombre = sheetView.findViewById(R.id.bottom_nombre);
                TextView bottomPrecio = sheetView.findViewById(R.id.bottom_precio);
                TextView bottomRating = sheetView.findViewById(R.id.bottom_rating);

                bottomNombre.setText(mNombre);
                bottomPrecio.setText(mPrecio);
                bottomRating.setText(mRating);
                bottomImg.setImageResource(mImagen);

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();

            }
        });
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
