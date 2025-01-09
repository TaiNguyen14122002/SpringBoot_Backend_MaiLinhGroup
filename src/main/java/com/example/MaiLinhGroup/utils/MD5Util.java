package com.example.MaiLinhGroup.utils;

import java.security.MessageDigest;

public class MD5Util {

    public static String encrypt(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();

        }catch(Exception e){
            throw new RuntimeException("Lỗi mã hóa MD5", e);
        }
    }

}
