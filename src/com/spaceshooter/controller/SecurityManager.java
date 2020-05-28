package com.spaceshooter.controller;

import java.io.File;

public class SecurityManager {
    public String loggedInUser;
    private File registerdUserFile;

    public SecurityManager(){

    }

    public boolean login (String username,String password){
        return false;
    }

    public boolean register(String username, String password,String confirmPassword){
        return false;
    }
}
