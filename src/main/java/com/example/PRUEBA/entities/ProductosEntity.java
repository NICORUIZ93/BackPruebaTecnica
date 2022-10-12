package com.example.PRUEBA.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "productos")
public class ProductosEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio")
    private Double precio;

}
