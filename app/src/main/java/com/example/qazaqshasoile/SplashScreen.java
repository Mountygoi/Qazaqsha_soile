package com.example.qazaqshasoile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {
    FirebaseAuth auth;
    ImageView wel,qosh,kiiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    kiiz = findViewById(R.id.kiiz);
    qosh = findViewById(R.id.qosh);
    wel = findViewById(R.id.wel);
    auth = FirebaseAuth.getInstance();


     new Handler().postDelayed(new Runnable() {
         @Override
         @SuppressLint("MissingInflatedId")
         public void run() {
             if(auth.getCurrentUser()!=null){
                 startActivity(new Intent(SplashScreen.this,MainActivity.class));
             }
             else{
                 startActivity(new Intent(SplashScreen.this,UserManager.class));
             }
             finish();
         }
     }, 2000  );

    }
}