package com.example.PRUEBA.services;

import org.springframework.stereotype.Service;

@Service
public class ConvertImage {

    public byte[] conversionBase64(String image) {
        byte[] ImagenBase64 = image.getBytes();
        System.out.println(ImagenBase64.toString());
        return ImagenBase64;
    }

}
