package com.example.PRUEBA.models;

import javax.persistence.Transient;

import lombok.Data;

@Data

public class ProductoModel {
    @Transient
    private Long id;
    private String descripcion;
    private String imagen;
    private String nombre;
    private Double precio;
}
