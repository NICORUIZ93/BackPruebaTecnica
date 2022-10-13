package com.example.PRUEBA.controllers;

import com.example.PRUEBA.entities.ProductosEntity;
import com.example.PRUEBA.models.ProductoModel;
import com.example.PRUEBA.repositories.repositoryImpl.ProductosRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Swagger http://localhost:8080/swagger-ui/index.html 

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosRepositoryImpl productosRepository;

    @GetMapping("/getProductos")
    public ResponseEntity<List<ProductoModel>> getProductos() {

        return productosRepository.productosFindAll();
    }

    @PostMapping("/newProducto")
    public ResponseEntity<ProductosEntity> newProducto(@RequestBody ProductoModel model) {

        return productosRepository.IngresarProducto(model);

    }

    @PutMapping("/updateProducto/{id}")
    public ResponseEntity<ProductosEntity> updateProducto(@PathVariable("id") Long id,
                                                          @RequestBody ProductoModel model) {

        return productosRepository.actualizar(id, model);

    }

    @DeleteMapping("/deleteProducto/{id}")
    public ResponseEntity<ProductosEntity> deleteProducto(@PathVariable("id") Long id) {

        return productosRepository.eliminarProducto(id);

    }

}
