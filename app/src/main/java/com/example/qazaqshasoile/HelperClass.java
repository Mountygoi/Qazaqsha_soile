package com.example.qazaqshasoile;

import com.google.firebase.auth.FirebaseAuth;

public class HelperClass {

    String email,username,password,smAuth;

    public String getEmail() {
        return email;
    }



    public void setEmail(String email) {
        this.email = email;
    }

//    public String getSmAuth() {
//        return smAuth;
//    }
//
//    public void setSmAuth(String smAuth) {
//        this.smAuth = smAuth;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public HelperClass(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
//        this.smAuth = smAuth;
//    }
    }
}
