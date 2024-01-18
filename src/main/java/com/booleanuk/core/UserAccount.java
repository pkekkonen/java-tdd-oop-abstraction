package com.booleanuk.core;

public class UserAccount {
    private String email;
    private String password;
    private boolean enabled;

    public UserAccount(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public boolean isEnabled() {
        return enabled;
    }

    public void enable() {
        enabled = true;
    }

    public void disable() {
        enabled = false;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) obj;

        return this.email.equals(other.email) && this.password.equals(other.password);
    }

    public boolean isCorrectPassword(String password) {
        return this.password.equals(password);
    }
}
