package com.example.qazaqshasoile;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class Books extends Fragment {
 @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_books, container, false);
     ImageView book = view.findViewById(R.id.q1);
     book.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Fragment book1 = new book1();
             FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
             fragmentTransaction.replace(R.id.frame_container, book1).addToBackStack(null).commit();
         }
     });
     ImageView book2 = view.findViewById(R.id.a1);
     book2.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Fragment book2 = new book2();
             FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
             fragmentTransaction.replace(R.id.frame_container, book2).addToBackStack(null).commit();
         }
     });
     ImageView book3 = view.findViewById(R.id.k1);
     book3.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Fragment book3 = new book3();
             FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
             fragmentTransaction.replace(R.id.frame_container, book3).addToBackStack(null).commit();
         }
     });
     ImageView book4 = view.findViewById(R.id.j1);
     book4.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Fragment book4 = new book4();
             FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
             fragmentTransaction.replace(R.id.frame_container, book4).addToBackStack(null).commit();
         }
     });

     return view;
 }
}