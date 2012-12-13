package com.swapnil.helloworld.util;

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
    public static String getEncodedPassword(String username, String password) throws NoSuchAlgorithmException {
        String secret = username + password;
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
