package com.example.qazaqshasoile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Makal1 extends Fragment {

  @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_makal1, container, false);
      ImageView back1 = view.findViewById(R.id.backmakal1);
        back1.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Fragment makal1 = new Makal();
              FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
              fragmentTransaction.replace(R.id.frame_container, makal1).addToBackStack(null).commit();
          }
      });

      return view;
    }
}