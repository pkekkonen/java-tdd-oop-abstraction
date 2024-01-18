package com.booleanuk.core;

public class System {
    public String createUser(String email, String password) {
        if(!isPasswordValid(password)) {
            return "invalid password";
        }
        return "User created";
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 8;
    }
}
