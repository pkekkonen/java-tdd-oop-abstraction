package com.booleanuk.core;

public class System {
    public String createUser(String email, String password) {
        if(!isPasswordValid(password)) {
            return "invalid password";
        }
        if(!isEmailValid(email)) {
            return "invalid email";
        }
        return "user created";
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }
}
