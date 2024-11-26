package com.example.proyectoapp.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectoapp.R;
import com.example.proyectoapp.adapters.HomeHorizontalAdapter;
import com.example.proyectoapp.adapters.HomeVerticalAdapter;
import com.example.proyectoapp.adapters.UpdateVerticalRec;
import com.example.proyectoapp.models.HomeHorizontalModel;
import com.example.proyectoapp.models.HomeVerticalModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements UpdateVerticalRec {

    RecyclerView homeHorizontalRec,homeVerticalRec;
    ArrayList<HomeHorizontalModel> homeHorizontalModelList;
    HomeHorizontalAdapter homeHorizontalAdapter;

    //Deslizar hacia abajo (vertical)
    ArrayList<HomeVerticalModel> homeVerticalModelList;
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

        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.pizza,"Pizza"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.hamburguesa,"Hamburguesa"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.pastas,"Pastas"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.bebidas,"Bebidas"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.postres,"Postres"));

        homeHorizontalAdapter = new HomeHorizontalAdapter(this,getActivity(),homeHorizontalModelList);
        homeHorizontalRec.setAdapter(homeHorizontalAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);



        //Vista vertical (deslizar abajo)
        homeVerticalModelList = new ArrayList<>();

        homeVerticalAdapter = new HomeVerticalAdapter(getActivity(),homeVerticalModelList);
        homeVerticalRec.setAdapter(homeVerticalAdapter);
        homeVerticalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));



        return root;
    }

    @Override
    public void callBack(int position, ArrayList<HomeVerticalModel> list) {

        homeVerticalAdapter = new HomeVerticalAdapter(getContext(),list);
        homeVerticalAdapter.notifyDataSetChanged();
        homeVerticalRec.setAdapter(homeVerticalAdapter);

    }
}