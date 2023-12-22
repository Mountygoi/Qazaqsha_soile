package com.example.qazaqshasoile;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.annotation.NonNull;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.Objects;
public interface RegistrationManagerFactory {
    RegistrationManager createRegistrationManager(Context context);
    interface RegistrationManager {
        void setEmail(String email);
        void setUser(String user);
        void setPassword(String password);
        void registerUser();
    }
}
class DefaultRegistrationManagerFactory implements RegistrationManagerFactory {
    @Override
    public RegistrationManager createRegistrationManager(Context context) {
        return new DefaultRegistrationManager(context);
    }
    private static class DefaultRegistrationManager implements RegistrationManager {
        private final Context context;
        private final FirebaseAuth mAuth;
        private final DatabaseReference reference;
        private String email;
        private String user;
        private String password;
        private DefaultRegistrationManager(Context context) {
            this.context = context;
            mAuth = FirebaseAuth.getInstance();
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            reference = database.getReference("users");
        }
        @Override
        public void setEmail(String email) {
            this.email = email;
        }
        @Override
        public void setUser(String user) {
            this.user = user;
        }
        @Override
        public void setPassword(String password) {
            this.password = password;
        }
        @Override
        public void registerUser() {
            mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(authResult -> {
                Objects.requireNonNull(mAuth.getCurrentUser()).sendEmailVerification().addOnCompleteListener(task -> {
                    String smAuth = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
                    HelperClass helperClass = new HelperClass(email, user, password);
                    reference.child(smAuth).setValue(helperClass);
                    Toast.makeText(context, "Сіз сәтті тіркелдіңіз! , Поштаңызға сілтеме жіберілді", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, UserManager.class);
                    context.startActivity(intent);
                });
            }).addOnFailureListener(e -> Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show());
        }
    }
}