package com.example.qazaqshasoile;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.material.textfield.TextInputEditText;
public class RegistrationManager extends AppCompatActivity {
    TextInputEditText email_et_reg, user_et_reg, password_et_reg;
    TextView artka;
    Button regnextbutton;
    RegistrationManagerFactory.RegistrationManager registrationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_manager);
        email_et_reg = findViewById(R.id.email_et_reg);
        user_et_reg = findViewById(R.id.user_et_reg);
        password_et_reg = findViewById(R.id.password_et_reg);
        artka = findViewById(R.id.artka);
        regnextbutton = findViewById(R.id.regnextbutton);
        registrationManager = new DefaultRegistrationManagerFactory().createRegistrationManager(this);
        regnextbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUsername() && validatePassword() && validateEmail()) {
                    registrationManager.setEmail(email_et_reg.getText().toString().trim());
                    registrationManager.setUser(user_et_reg.getText().toString().trim());
                    registrationManager.setPassword(password_et_reg.getText().toString().trim());
                    registrationManager.registerUser();
                }
            }
        });
        artka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationManager.this, UserManager.class);
                startActivity(intent);
            }
        });
    }
    public Boolean validateUsername() {
        String val = user_et_reg.getText().toString().trim();
        if (val.isEmpty()) {
            Toast.makeText(RegistrationManager.this, "Толтыру міндетті", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    public Boolean validatePassword() {
        String valp = password_et_reg.getText().toString().trim();
        if (valp.isEmpty()) {
            Toast.makeText(RegistrationManager.this, "Толтыру міндетті", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    public Boolean validateEmail() {
        String valq = email_et_reg.getText().toString().trim();
        if (valq.isEmpty()) {
            Toast.makeText(RegistrationManager.this, "Толтыру міндетті", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}