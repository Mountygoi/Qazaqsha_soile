package com.example.qazaqshasoile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class TestFragment extends Fragment {
  Button quiz1,quiz2,quiz3;

    FragmentManager fragmentManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_test, container, false);

        quiz1 = view.findViewById(R.id.quiz1);
        quiz1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment quiz11 = new Quiz1();
                FragmentTransaction  transaction = requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, quiz11).commit();
            }
        });
        quiz2 = view.findViewById(R.id.quiz2);
        quiz2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment quiz2 = new Quiz2();
                FragmentTransaction  transaction = requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, quiz2).commit();
            }
        });
        quiz3 = view.findViewById(R.id.quiz3);
        quiz3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment quiz3 = new Quiz3();
                FragmentTransaction  transaction = requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, quiz3).commit();
            }
        });

        return view;
    }
}