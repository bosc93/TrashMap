package com.example.cesar.trashmap;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class UserBDD {

    public String username;
    public String email;
    public int exp;

    public UserBDD() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public UserBDD(String username, String email, int exp) {
        this.username = username;
        this.email = email;
        this.exp = exp;
    }

}