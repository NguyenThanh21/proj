package com.nguyenthanh.proj.utils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncryptions {
    public static String encrypteBcryptPassword(String password){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
        return encoder.encode(password);
    }
    public static boolean bCryptPasswordEncoder(String password, String passwordEncryte){
        return new BCryptPasswordEncoder().matches(password, passwordEncryte);
    }
}
