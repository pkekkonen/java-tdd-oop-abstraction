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

}
