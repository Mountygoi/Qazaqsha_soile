package com.example.qazaqshasoile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class StudyFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public StudyFragment() {
    }

    public static StudyFragment newInstance(String param1, String param2) {
        StudyFragment fragment = new StudyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_study, container, false);
        ImageView filmuz = view.findViewById(R.id.filmuz);
        ImageView makalmatel = view.findViewById(R.id.makalmatel);
        ImageView kitaptar = view.findViewById(R.id.kitaptar);
        filmuz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment filmfragment = new Filmkoru();
                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, filmfragment).commit();
            }
        });

        makalmatel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment makal = new Makal();
                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, makal).commit();
            }
        });

        kitaptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment kitap = new Books();
                FragmentTransaction transaction = getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, kitap).commit();
            }
        });
        return view;
    }

}










