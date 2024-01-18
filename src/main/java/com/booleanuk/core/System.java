package com.booleanuk.core;

import java.util.ArrayList;
import java.util.HashMap;

public class System {
    private HashMap<String, UserAccount> users = new HashMap<>();

    public String createUser(String email, String password) {
        if(!isPasswordValid(password)) {
            return "invalid password";
        }
        if(!isEmailValid(email)) {
            return "invalid email";
        }
        users.put(email, new UserAccount(email, password));
        return "user created";
    }

    public UserAccount login(String email, String password) {
        UserAccount user = users.get(email);
        if(!user.isCorrectPassword(password)) {
            return null;
        }
        return user;
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }
}
