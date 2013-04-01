package com.demoapp.demo.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created with IntelliJ IDEA.
 * User: sdipankar
 * Date: 12/12/12
 * Time: 6:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class PasswordEncoder {
    private static String generateSecretFromUsernamePassword(String username, String password) {
        if((username == null) && (password == null)) {
            return "";
        }
        if(username == null) {
            return password;
        }
        if(password == null) {
            return username;
        }
        int i=0;
        int j=0;
        StringBuilder stringBuilder = new StringBuilder();
        while(i <= username.length() && j <= password.length()) {
            if(i == username.length()) {
                stringBuilder.append(password.substring(j));
                return stringBuilder.toString();
            } else if(j == password.length()) {
                stringBuilder.append(username.substring(i));
                return stringBuilder.toString();
            }
            stringBuilder.append(password.charAt(j++));
            stringBuilder.append(username.charAt(i++));
        }
        return stringBuilder.toString();
    }

    public static String getEncodedPassword(String username, String password) throws NoSuchAlgorithmException {
        String secret = generateSecretFromUsernamePassword(username, password);
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(secret.getBytes());

        byte byteData[] = messageDigest.digest();
        StringBuffer stringBuffer = new StringBuffer();
        for (int idx=0; idx<byteData.length; idx++) {
            stringBuffer.append(Integer.toString((byteData[idx] & 0xff) + 0x100, 16).substring(1));
        }

        return stringBuffer.toString();
    }
}
