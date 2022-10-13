package com.example.PRUEBA.services;

import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class ConvertImage {

    public byte[] conversionToByte(String image) {
        byte[] ImagenBase64 = image.getBytes(StandardCharsets.UTF_8);
        return ImagenBase64;
    }

    public String conversionToString(byte[] base64) {

        return new String(base64);
    }
}
