package com.example.qazaqshasoile;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Filmkoru extends Fragment {
MainActivity mainActivity;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_filmkoru, container, false);
        ImageView play = rootView.findViewById(R.id.play1);
        ImageView play2 = rootView.findViewById(R.id.play2);
        ImageView play3 = rootView.findViewById(R.id.play3);
       mainActivity = (MainActivity)getActivity();
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Film1();
                FragmentTransaction  transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container,fragment).commit();
            }
        });

        play2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Film2();
                FragmentTransaction  transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container,fragment).commit();
            }
        });

        play3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new Film3();
                FragmentTransaction  transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container,fragment).commit();
            }
        });

        return rootView;
    }


}