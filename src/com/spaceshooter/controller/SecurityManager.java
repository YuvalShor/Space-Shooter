package com.spaceshooter.controller;

import com.spaceshooter.view.User;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class SecurityManager {
    private static Map<String, User> usersMap = new HashMap<String, User>();

    static{
        User newUser = new User("123", "123");
        usersMap.put("123", newUser);
    }

    public static boolean login (String username,String password) throws Exception {
        return checkLoginInformation(username, password);
    }

    public static void register(String username, String password){
        String hashedPassword =  getSha1Hex(password);
        User newUserToRegister = new User(username, hashedPassword);

        usersMap.put(username, newUserToRegister);
    }

    private static String getSha1Hex(String clearString)
    {
        try
        {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(clearString.getBytes(StandardCharsets.UTF_8));
            byte[] bytes = messageDigest.digest();
            StringBuilder buffer = new StringBuilder();
            for (byte b : bytes)
            {
                buffer.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            return buffer.toString();
        }
        catch (Exception ignored)
        {
            ignored.printStackTrace();
            return null;
        }
    }

    private static boolean checkLoginInformation(String username, String password) throws Exception {
        String passText = getSha1Hex(password);

        if(usersMap.containsKey(username)){
            if(usersMap.get(username).getPassword().equals(passText)) {
                return true;
            }
            else{
                throw new Exception("Incorrect Password");
            }
        }else{
            return false;
        }

    }

}
