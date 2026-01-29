package com.scaler.splitwise.services.interfaces;

public interface PasswordEncoder {
    String encode(String plainText);

    boolean matches(String plainText, String hashed);
}
