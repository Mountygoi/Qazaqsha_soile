package com.example.qazaqshasoile;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class book4 extends Fragment {
    int i=0;
    TextView count;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book4, container, false);
        count = view.findViewById(R.id.counterj);
        count.setText(String.valueOf(i+1));
        ImageView next = view.findViewById(R.id.nextj);
        ImageView back = view.findViewById(R.id.backj);
        ImageView[] imageViews = new ImageView[5];
        imageViews[0] = view.findViewById(R.id.j2);
        imageViews[1] = view.findViewById(R.id.j3);
        imageViews[2] = view.findViewById(R.id.j4);
        imageViews[3] = view.findViewById(R.id.j5);
        imageViews[4] = view.findViewById(R.id.j6);



        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i != 4) {
                    imageViews[i].setVisibility(View.GONE);
                    i++;
                    count.setText(String.valueOf(i+1));
                    imageViews[i].setVisibility(View.VISIBLE);
                }
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(i!=0) {
                    imageViews[i].setVisibility(View.GONE);
                    i--;
                    count.setText(String.valueOf(i+1));
                    imageViews[i].setVisibility(View.VISIBLE);

                }        }
        });







        return view;
    }
}