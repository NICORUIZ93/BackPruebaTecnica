package com.example.PRUEBA.entities;

import lombok.Data;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Data
@Table(name = "productos")
public class ProductosEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private byte[] imagen;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

}
