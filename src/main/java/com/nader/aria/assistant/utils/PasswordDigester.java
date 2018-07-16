package com.nader.aria.assistant.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordDigester  {

    private static PasswordDigester instance;

    public synchronized static PasswordDigester getInstance(){

        if( instance == null ){
            instance = new PasswordDigester();
        }
        return instance;
    }

    private PasswordDigester(){

    }

    public static String digest(String password,String salt){

        if ( password == null || password.isEmpty() || salt == null || salt.isEmpty() ){
            throw new IllegalArgumentException("password or salt is null;");
        }

        try {

            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int halfValue = salt.length()/2;
            String firstPart = salt.substring(0,halfValue)+"AssistantProject";
            String secondPart = salt.substring(halfValue)+"NADER_ARIA";
            messageDigest.update(firstPart.getBytes());
            messageDigest.update(password.getBytes());
            messageDigest.update(secondPart.getBytes());

            return new String(messageDigest.digest(), "UTF-8");

        }catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
           throw  new RuntimeException("Can't Convert Password to secretKey;");
        }

    }
}
