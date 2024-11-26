package com.example.proyectoapp.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapp.R;
import com.example.proyectoapp.models.HomeHorizontalModel;
import com.example.proyectoapp.models.HomeVerticalModel;

import java.util.ArrayList;
import java.util.List;

public class HomeHorizontalAdapter extends RecyclerView.Adapter<HomeHorizontalAdapter.ViewHolder> {

    UpdateVerticalRec updateVerticalRec;
    Activity activity;
    ArrayList<HomeHorizontalModel> list;

    boolean check = true;
    boolean select = true;
    int row_index = -1;

    public HomeHorizontalAdapter( UpdateVerticalRec updateVerticalRec,Activity activity, ArrayList<HomeHorizontalModel> list) {
        this.updateVerticalRec = updateVerticalRec;
        this.activity = activity;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.deslizar_home,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(list.get(position).getImagen());
        holder.nombre.setText(list.get(position).getNombre());

        if(check) {
            ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();
            homeVerticalModels.add(new HomeVerticalModel(R.drawable.pizzahawaiana, "Pizza Hawaiana", "10:00 - 20:00 min", "4.1", "$129.00"));
            homeVerticalModels.add(new HomeVerticalModel(R.drawable.pizzapeperonni, "Pizza De Pepperoni", "10:00 - 15:00 min", "4.9", "$119.00"));
            homeVerticalModels.add(new HomeVerticalModel(R.drawable.pizzamexicana, "Pizza Mexicana", "10:00 - 30:00 min", "4.8", "199.00"));
            homeVerticalModels.add(new HomeVerticalModel(R.drawable.pizzaqueso, "Pizza De Queso", "10:00 - 15:00 min", "4.0", "$89.00"));

            updateVerticalRec.callBack(position, homeVerticalModels);
            check = false;
        }

            holder.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    row_index = position;
                    notifyDataSetChanged();

                    if(position == 0){
                        ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();

                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.pizzahawaiana,"Pizza Hawaiana","10:00 - 20:00 min","4.1","$129.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.pizzapeperonni,"Pizza De Pepperoni","10:00 - 15:00 min","4.9","$119.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.pizzamexicana,"Pizza Mexicana","10:00 - 30:00 min","4.8","199.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.pizzaqueso,"Pizza De Queso","10:00 - 15:00 min","4.0","$89.00"));

                        updateVerticalRec.callBack(position,homeVerticalModels);


                    }
                    else if (position == 1) {

                        ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();

                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.burgersencilla,"Hamburguesa Sencilla ","10:00 - 20:00 min","4.1","$109.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.burguertocino,"Hamburguesa con Tocino","8:00 - 20:00 min","4.9","$139.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.burgerdoble,"Hamburguesa Doble","10:00 - 25:00 min","4.8","$149.00"));

                        updateVerticalRec.callBack(position,homeVerticalModels);
                        
                    }
                    else if (position == 2) {

                        ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();

                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.espagetibolognesa,"Spaghetti a la Bolognesa ","10:00 - 30:00 min","4.1","$250.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.espagetisalsatomate,"Spaghetti con Salsa de Tomate","13:00 - 25:00 min","3.9","$210.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.espagettialbondigas,"Spaghetti con Albondigas","15:00 - 45:00 min","4.9","$220.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.macarronestomatequesojpg,"Macarrones con Queso","10:00 - 25:00 min","5.0","$149.00"));


                        updateVerticalRec.callBack(position,homeVerticalModels);
                    }
                    else if (position == 3) {

                        ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();

                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.cocacola,"Coca-Cola 600ml ","","","$35.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.pepsi,"Pepsi 600ml ","","","$35.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.aguahorchata,"Agua de Horchata 1L","","","$40.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.aguajamaica,"Agua de Jamaica 1L","","","$50.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.agualimon,"Agua de Limon 1L","","","$50.00"));


                        updateVerticalRec.callBack(position,homeVerticalModels);
                    }
                    else if (position == 4) {

                        ArrayList<HomeVerticalModel> homeVerticalModels = new ArrayList<>();

                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.flan,"Flan de Queso","5:00 - 10:00 min","4.1","$85.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.pastel,"Pastel Red Velvet","5:00 - 10:00 min","4.9","$70.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.helado,"Helado de Chocolate","5:00 - 10:00 min","4.8","$85.00"));
                        homeVerticalModels.add(new HomeVerticalModel(R.drawable.heladovainilla,"Helado de Vainilla","5:00 - 10:00 min","4.8","$85.00"));


                        updateVerticalRec.callBack(position,homeVerticalModels);
                    }

                }
            });

            if(select){
                if(position == 0){
                    holder.cardView.setBackgroundResource(R.drawable.cambio_bg);
                    select = false;
                }
            }
            else{
                if (row_index == position){
                    holder.cardView.setBackgroundResource(R.drawable.cambio_bg);
                }else{
                    holder.cardView.setBackgroundResource(R.drawable.default_bg);

                }
            }


        }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView nombre;
        CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.hor_img);
            nombre = itemView.findViewById(R.id.hor_text);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}