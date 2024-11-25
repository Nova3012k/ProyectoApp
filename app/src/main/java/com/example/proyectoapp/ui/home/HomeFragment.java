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
import com.example.proyectoapp.databinding.FragmentHomeBinding;
import com.example.proyectoapp.models.HomeHorizontalModel;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView homeHorizontalRec;
    List<HomeHorizontalModel> homeHorizontalModelList;
    HomeHorizontalAdapter homeHorizontalAdapter;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home,container,false);

        homeHorizontalRec = root.findViewById(R.id.home_hor_rec);

        homeHorizontalModelList = new ArrayList<>();

        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.pizza,"Pizza"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.hamburguesa,"Hamburguesa"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.sandwich,"Sandwich"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.papas,"Papas"));
        homeHorizontalModelList.add(new HomeHorizontalModel(R.drawable.helado,"Helados"));

        homeHorizontalAdapter = new HomeHorizontalAdapter(getActivity(), homeHorizontalModelList);
        homeHorizontalRec.setAdapter(homeHorizontalAdapter);
        homeHorizontalRec.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false));
        homeHorizontalRec.setHasFixedSize(true);
        homeHorizontalRec.setNestedScrollingEnabled(false);
        return root;
    }
}