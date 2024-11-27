package com.example.proyectoapp.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.proyectoapp.R;
import com.example.proyectoapp.adapters.CarritoAdapter;
import com.example.proyectoapp.models.CarritoModel;

import java.util.ArrayList;
import java.util.List;

public class CarritoFragment extends Fragment {

    List<CarritoModel> list;
    CarritoAdapter carritoAdapter;
    RecyclerView recyclerView;


    public CarritoFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_carrito, container, false);

        recyclerView = view.findViewById(R.id.carrito_rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();
        list.add(new CarritoModel(R.drawable.burgerdoble,"Orden 1","$119","5.0"));
        list.add(new CarritoModel(R.drawable.espagettialbondigas,"Orden 1","$150","5.0"));
        list.add(new CarritoModel(R.drawable.cocacola,"Orden 1","$25","5.0"));
        list.add(new CarritoModel(R.drawable.burgerdoble,"Orden 1","$40","5.0"));
        list.add(new CarritoModel(R.drawable.espagettialbondigas,"Orden 1","$30","5.0"));
        list.add(new CarritoModel(R.drawable.cocacola,"Orden 1","$50","5.0"));
        carritoAdapter = new CarritoAdapter(list);
        recyclerView.setAdapter(carritoAdapter);


        return view;
    }
}