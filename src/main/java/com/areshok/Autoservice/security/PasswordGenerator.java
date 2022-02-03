package com.areshok.Autoservice.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "ares";
        String encoderPassword = encoder.encode(rawPassword);

        System.out.println(encoderPassword);
    }
}
