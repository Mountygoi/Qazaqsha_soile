package com.example.qazaqshasoile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
public class ForgotManager extends AppCompatActivity {
    Button zhberuemail;
    TextInputEditText email_et_forgot;
    TextView esmetustu;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_manager);
        zhberuemail = findViewById(R.id.zhberuemail);
        email_et_forgot = findViewById(R.id.email_et_forgot);
        esmetustu = findViewById(R.id.esmetustu);
        mAuth=FirebaseAuth.getInstance();
        zhberuemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailinput = email_et_forgot.getText().toString().trim();
                if (emailinput.isEmpty()) {
                    email_et_forgot.setError("Толтыру міндетті");
                } else {
                    mAuth.sendPasswordResetEmail(emailinput)
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(ForgotManager.this, "Сіздің поштаңызға сілтеме жіберілді!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new IntentBuilder(ForgotManager.this)
                                            .setTargetActivity(UserManager.class)
                                            .build();
                                    startActivity(intent);
                                    finish();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(ForgotManager.this, "Қате : " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            }
        });
        esmetustu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new IntentBuilder(ForgotManager.this)
                        .setTargetActivity(UserManager.class)
                        .build();
                startActivity(intent);
            }
        });
    }
}