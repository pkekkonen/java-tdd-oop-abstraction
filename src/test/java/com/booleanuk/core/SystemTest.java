package com.booleanuk.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SystemTest {

    @Test
    public void createUserInvalidPassword() {
        System system = new System();
        String email = "bob@gmail.com";
        String password = "1234567";
        String actual = system.createUser(email, password);
        String expected = "invalid password";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createUserValidPassword() {
        System system = new System();
        String email = "bob@gmail.com";
        String password = "12345678";
        String actual = system.createUser(email, password);
        String expected = "user created";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createUserInvalidEmail() {
        System system = new System();
        String email = "bobgmail.com";
        String password = "12345678";
        String actual = system.createUser(email, password);
        String expected = "invalid email";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void createUserValidEmail() {
        System system = new System();
        String email = "bob@gmail.com";
        String password = "12345678";
        String actual = system.createUser(email, password);
        String expected = "user created";
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void newAccountIsDisabledTest() {
        System system = new System();
        String email = "bob@gmail.com";
        String password = "12345678";
        system.createUser(email, password);
        UserAccount user = system.login(email, password);
        Assertions.assertFalse(user.isEnabled());
    }

    @Test
    public void enableAccountTest() {
        System system = new System();
        String email = "bob@gmail.com";
        String password = "12345678";
        system.createUser(email, password);
        UserAccount user = system.login(email, password);
        user.enable();
        Assertions.assertTrue(user.isEnabled());
    }

    @Test
    public void logInFail() {
        System system = new System();
        String email = "bob@gmail.com";
        String password = "12345678";
        system.createUser(email, password);
        UserAccount user = system.login(email, "123456778");
        Assertions.assertNull(user);
    }
}
