package com.example.qazaqshasoile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class Makal extends Fragment {

 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_makal, container, false);
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("Үйлену, үй-іші, отбасы",R.drawable.otbasy));
        items.add(new Item("Ақыл-ой, ғылым-білім",R.drawable.oku));
        items.add(new Item("Байлық, кедейлік туралы",R.drawable.bailyk));
        items.add(new Item("Денсаулық – зор байлық",R.drawable.densaulyk));
        items.add(new Item("Жалғыздық",R.drawable.zhalgyz));
        items.add(new Item("Жер",R.drawable.zher));
        items.add(new Item("Су",R.drawable.su));
        items.add(new Item("Уақыт, дәуір",R.drawable.sagat));
        items.add(new Item("Батырлық пен қорқақтық",R.drawable.batyr));
        items.add(new Item("Аға",R.drawable.aga));
        items.add(new Item("Адамгершілік, жақсылық, қайырымдылық, мейірімділік",R.drawable.dos));
        items.add(new Item("Ас, тағам туралы",R.drawable.as));
        items.add(new Item("Аңшылық, саятшылық",R.drawable.hunter));
        items.add(new Item("Туған жер - Отан, ел-жұрт",R.drawable.kazakhstan));

        RecyclerView recyclerView = view.findViewById(R.id.rec);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerView.setAdapter(new MyAdapter(requireActivity().getApplicationContext(),items,requireActivity().getSupportFragmentManager()));
        return view;
    }
}