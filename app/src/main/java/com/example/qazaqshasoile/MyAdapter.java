package com.example.qazaqshasoile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {

   Context context;
   List<Item> items;
   FragmentManager fragmentManager;

    public MyAdapter(Context context,List<Item> items, FragmentManager fragmentManager ) {
        this.context = context;
        this.items = items;
        this.fragmentManager = fragmentManager;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
     holder.adi.setText(items.get(position).getName());
     holder.surett.setImageResource(items.get(position).getSuret());
     final int itemposition = position;
     holder.itemView.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
             switch (itemposition){
                 case 0:
                     Fragment fragment = new Makal1();
                     fragmentTransaction.replace(R.id.frame_container,fragment).commit();
                     break;
                     case 1:
                         Fragment fragment1 = new Makal2();
                         fragmentTransaction.replace(R.id.frame_container,fragment1).commit();
                         break;
                 case 2:
                     Fragment fragment2 = new Makal3();
                     fragmentTransaction.replace(R.id.frame_container,fragment2).commit();
                     break;
                 case 3:
                     Fragment fragment3 = new Makal4();
                     fragmentTransaction.replace(R.id.frame_container,fragment3).commit();
                     break;
                 case 4:
                     Fragment fragment4 = new Makal5();
                     fragmentTransaction.replace(R.id.frame_container, fragment4).commit();
                     break;
                 case 5:
                     Fragment fragment5 = new Makal6();
                     fragmentTransaction.replace(R.id.frame_container, fragment5).commit();
                     break;
                 case 6:
                     Fragment fragment6 = new Makal7();
                     fragmentTransaction.replace(R.id.frame_container, fragment6).commit();
                     break;
                 case 7:
                     Fragment fragment7 = new Makal8();
                     fragmentTransaction.replace(R.id.frame_container, fragment7).commit();
                     break;
                 case 8:
                     Fragment fragment8 = new Makal9();
                     fragmentTransaction.replace(R.id.frame_container, fragment8).commit();
                     break;
                 case 9:
                     Fragment fragment9 = new Makal10();
                     fragmentTransaction.replace(R.id.frame_container, fragment9).commit();
                     break;
                 case 10:
                     Fragment fragment10 = new Makal11();
                     fragmentTransaction.replace(R.id.frame_container, fragment10).commit();
                     break;
                 case 11:
                     Fragment fragment11 = new Makal12();
                     fragmentTransaction.replace(R.id.frame_container, fragment11).commit();
                     break;
                 case 12:
                     Fragment fragment12 = new Makal13();
                     fragmentTransaction.replace(R.id.frame_container, fragment12).commit();
                     break;
                 case 13:
                     Fragment fragment13 = new Makal14();
                     fragmentTransaction.replace(R.id.frame_container, fragment13).commit();
                     break;

             }
         }
     });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
