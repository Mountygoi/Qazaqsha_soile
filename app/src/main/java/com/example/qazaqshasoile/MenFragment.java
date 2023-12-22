package com.example.qazaqshasoile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MenFragment extends Fragment {

MainActivity mainActivity;
String name,email;
TextView imya,pochta,zhana;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_men, container, false);

        Button logout = rootView.findViewById(R.id.logout);
        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = auth.getCurrentUser();
        if(firebaseUser!=null) {
            String userID = firebaseUser.getUid();

            DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
            reference.child(userID).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    name = snapshot.child("username").getValue(String.class);
                    email = firebaseUser.getEmail();

                    imya.setText(name);
                    pochta.setText(email);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });        }
        zhana = rootView.findViewById(R.id.zhana);
        imya = rootView.findViewById(R.id.imya);
        pochta = rootView.findViewById(R.id.poshta);
        mainActivity = (MainActivity)getActivity();

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.signOut();
                goToUserManagerActivity();
            }
        });
       zhana.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               auth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                           @Override
                           public void onSuccess(Void unused) {
                               Toast.makeText(requireContext(),"Сіздің поштаңызға сілтеме жіберілді!",Toast.LENGTH_SHORT).show();
                               ;
                           }
                       })
                       .addOnFailureListener(new OnFailureListener() {
                           @Override
                           public void onFailure(@NonNull Exception e) {
                               Toast.makeText(requireContext(),"Қате : " + e.getMessage(),Toast.LENGTH_SHORT).show();
                           }
                       });
           }
       });


        return rootView;
    }
    private void goToUserManagerActivity() {
        Intent intent = new Intent(getActivity(), UserManager.class);
intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

        getActivity().finish();
    }
}




