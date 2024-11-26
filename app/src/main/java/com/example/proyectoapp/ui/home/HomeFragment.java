package com.example.proyectoapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapp.R;
import com.example.proyectoapp.adapters.HomeHorizontalAdapter;
import com.example.proyectoapp.adapters.HomeVerticalAdapter;
import com.example.proyectoapp.databinding.FragmentHomeBinding;
import com.example.proyectoapp.models.HomeHorizontalModel;
import com.example.proyectoapp.models.HomeVerticalModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    List<HomeHorizontalModel> homeHorizontalModelList;
    HomeHorizontalAdapter homeHorizontalAdapter;

    //Deslizar hacia abajo (vertical)
    List<HomeVerticalModel> homeVerticalModelList;
    HomeVerticalAdapter homeVerticalAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);

        //horizontal
        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);
        //vertical
        homeVerticalRec = root.findViewById(R.id.home_ver_rec);

        //Vista horizontal (deslizar derecha)
        homeHorizontalModelList = new ArrayList<>();

        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.pizza,"            Pizza"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.hamburguesa,"Hamburguesa"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.sandwich,"        Sandwich"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.papas,"           Papas"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.helado,"         Helados"));

        homeHorizontalAdapter = new HomeHorizontalAdapter(getActivity(), homeHorizontalModelList);
        homeHorizontalRec.setAdapter(homeHorizontalAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);



        //Vista vertical (deslizar abajo)
        homeVerticalModelList = new ArrayList<>();

        homeVerticalModelList.add(new HomeVerticalModel(R.drawable.pizzahawaiana,"Pizza Hawaiana","10:00 - 20:00 min","4.1","$129.00"));
        homeVerticalModelList.add(new HomeVerticalModel(R.drawable.pizzapeperonni,"Pizza De Pepperoni","10:00 - 15:00 min","4.9","$99.00"));
        homeVerticalModelList.add(new HomeVerticalModel(R.drawable.pizzamexicana,"Pizza Mexicana","10:00 - 30:00 min","4.4","199.00"));

        homeVerticalAdapter = new HomeVerticalAdapter(getActivity(),homeVerticalModelList);
        homeVerticalRec.setAdapter(homeVerticalAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        homeVerticalRec.setHasFixedSize(true);
        homeVerticalRec.setNestedScrollingEnabled(false);


        return root;
    }
}