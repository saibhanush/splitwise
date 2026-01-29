package com.scaler.splitwise.services.interfaces;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptEncoder implements  PasswordEncoder {
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public String encode(String plainText) {
        return passwordEncoder.encode(plainText);
    }

    @Override
    public boolean matches(String plainText, String hashed) {
        return passwordEncoder.matches(plainText, hashed);
    }
}
