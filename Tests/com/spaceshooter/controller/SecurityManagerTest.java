package com.spaceshooter.controller;


import com.spaceshooter.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.junit.rules.ExpectedException;

class SecurityManagerTest {
    private User user;

    @AfterEach
    void tearDown() {
    }

    @Test
    void loginTest()  {

       Assertions.assertThrows(Exception.class, () ->
            SecurityManager.login("", ""));

       Assertions.assertThrows(Exception.class, () ->
                SecurityManager.login("", "123shfois1"));

       Assertions.assertThrows(Exception.class, () ->
                SecurityManager.login("yuval", ""));

       Assertions.assertThrows(Exception.class, () ->
                SecurityManager.login("abc$$$$$$$$$$$$", "zzzzzzzzzzzzzzzz"));
    }

    @Test
    void registerTest() {
        Assertions.assertThrows(Exception.class, () ->
                SecurityManager.register("", ""));

        Assertions.assertNull(SecurityManager.getUser(""));

        Assertions.assertThrows(Exception.class, () ->
                SecurityManager.register("", "123shfois1"));

        Assertions.assertNull(SecurityManager.getUser(""));

        Assertions.assertThrows(Exception.class, () ->
                SecurityManager.register("someusername", ""));

        Assertions.assertNull(SecurityManager.getUser("someusername"));

        Assertions.assertThrows(Exception.class, () ->
                SecurityManager.register("abc$$$$$$$$$$$$", "zzzzzzzzzzzzzzzz"));

        Assertions.assertNull(SecurityManager.getUser("abc$$$$$$$$$$$$"));

        Assertions.assertDoesNotThrow(() ->
                SecurityManager.register("goodusername", "goodpassword"));

        Assertions.assertTrue(SecurityManager.deleteUser("goodusername"));
    }
}