package com.example.PRUEBA.repositories.repositoryCustom;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.PRUEBA.entities.ProductosEntity;
import com.example.PRUEBA.models.ProductoModel;

public interface ProductosRepositoryCustom {

    public ResponseEntity<ProductosEntity> actualizar(Long id, ProductoModel model);

    public ResponseEntity<ProductosEntity> IngresarProducto(ProductoModel model);

    public ResponseEntity<ProductosEntity> eliminarProducto(Long id);

    public ResponseEntity<List<ProductosEntity>> productosFindAll();

}
