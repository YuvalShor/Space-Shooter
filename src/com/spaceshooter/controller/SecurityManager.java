package com.spaceshooter.controller;

import com.spaceshooter.model.User;

import java.io.EOFException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Hashtable;
import java.util.Map;

public class SecurityManager {
    public static String currentUser;
    final static private String usersFilename = "users.dat";
    private static Map<String, User> usersMap;

    static{
        usersMap = (Map<String, User>) FileHandler.readObjectFromFile(usersFilename);

        if(usersMap == null){
            usersMap = new Hashtable<>();
        }
    }

    public static boolean login (String username,String password) throws Exception {
        return checkLoginInformation(username, password);
    }

    public static void register(String username, String password) throws Exception {
        validateInformation(username, password);

        String hashedPassword =  getSha1Hex(password);
        User newUserToRegister = new User(username, hashedPassword);

        if(usersMap.containsKey(username)) {
            throw new Exception("Username already exists");
        }

        currentUser = username;
        usersMap.put(username, newUserToRegister);
        FileHandler.writeObjectToFile(usersMap, usersFilename);
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
        validateInformation(username, password);

        String passText = getSha1Hex(password);

        if(usersMap.containsKey(username)){
            if(usersMap.get(username).getPassword().equals(passText)) {
                currentUser = username;
                return true;
            }
            else{
                throw new Exception("Incorrect Password");
            }
        }else{
            return false;
        }
    }

    private static void validateInformation(String username, String password) throws Exception {
        boolean isUsernameValid = true;

        if(username.length() < 4){
            isUsernameValid = false;
        }

        if(isUsernameValid){
            for (char letter : username.toCharArray()) {
                if(!Character.isLetterOrDigit(letter)){
                    isUsernameValid = false;
                }
            }
        }

        if(!isUsernameValid){
            throw new Exception("Username must be alphanumeric and at least 4 characters long");
        }

        // check password
        if(password.isEmpty() || password.length() < 8){
            throw new Exception("Password must be at least 8 characters long");
        }
    }

    public static boolean deleteUser(String username){
        User value = usersMap.remove(username);
        FileHandler.writeObjectToFile(usersMap, usersFilename);

        return value != null;
    }

    public static User getUser(String username){
        return usersMap.get(username);
    }

}
