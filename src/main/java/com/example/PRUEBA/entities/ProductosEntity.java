package com.example.PRUEBA.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "PRODUCTOS")
public class ProductosEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String nombre;
    String descripcion;
    double precio;
    String imagen;

}
