package com.example.demo.util;

import org.springframework.stereotype.Component;

@Component
public class Base62Encoder {

    private static final String BASE62_ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public String encode(long value) {
        StringBuilder sb = new StringBuilder();
        while (value > 0) {
            sb.insert(0, BASE62_ALPHABET.charAt((int) (value % 62)));
            value /= 62;
        }
        return sb.toString();
    }
}
