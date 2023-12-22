package com.example.qazaqshasoile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class UserManager extends AppCompatActivity {

    TextInputEditText email_et,password_et;
    Button kirubutton;
    TextView trkelulogin,zabylder;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_user_manager);

    zabylder = findViewById(R.id.zabylder);
    email_et = findViewById(R.id.email_et);
    password_et = findViewById(R.id.password_et);
    kirubutton = findViewById(R.id.kirubutton);
    trkelulogin = findViewById(R.id.trkelulogin);
    mAuth = FirebaseAuth.getInstance();


        kirubutton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            String userEmail = email_et.getText().toString().trim();
            String userPassword = password_et.getText().toString().trim();
            if(!validateUsername() || !validatePassword()){

            }else{
                mAuth.signInWithEmailAndPassword(userEmail,userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        if(Objects.requireNonNull(mAuth.getCurrentUser()).isEmailVerified()){
                            Toast.makeText(UserManager.this,   "Қош келдіңіз!",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(UserManager.this,MainActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(UserManager.this,"Сіз өзіңіздің поштаңызды растамыдыңыз !",Toast.LENGTH_SHORT).show();
                        }

                    }else {
                        Toast.makeText(UserManager.this,"Пошта немесе құпиясөз дұрыс емес",Toast.LENGTH_SHORT).show();
                    }
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(UserManager.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
            }
        }
    });
    trkelulogin.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(UserManager.this,RegistrationManager.class);
            startActivity(intent);
        }
    });

        zabylder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserManager.this, ForgotManager.class);
                startActivity(intent);
            }
        });

    }
    public Boolean validateUsername(){
        String val = email_et.getText().toString();
        if(val.isEmpty()){
            email_et.setError("Толтыру міндетті");
            return  false;
        }else {
            email_et.setError(null);
            return true;
        }
    }


    public Boolean validatePassword(){
        String val = password_et.getText().toString();
        if(val.isEmpty()){
            password_et.setError("Толтыру міндетті");
            return  false;
        }else {
            password_et.setError(null);
            return true;
        }
    }

}