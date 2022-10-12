package com.example.PRUEBA.controllers;

import com.example.PRUEBA.entities.ProductosEntity;
import com.example.PRUEBA.models.productoModel;
import com.example.PRUEBA.repositories.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Swagger http://localhost:8080/swagger-ui/index.html List<ProductosEntity> 

@RestController
@RequestMapping("/productos")
public class ProductosController {

    @Autowired
    private ProductosRepository productosRepository;

    @GetMapping("/getProductos")
    public ResponseEntity<List<ProductosEntity>> getProductos() {

        return new ResponseEntity<>(productosRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/newProducto")
    public ResponseEntity<ProductosEntity> newProducto(@RequestBody ProductosEntity producto) {

        try {
            productosRepository.save(producto);
        } catch (Exception e) {
            return new ResponseEntity<ProductosEntity>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<ProductosEntity>(producto, HttpStatus.CREATED);
    }

    @PutMapping("/updateProducto/{id}")
    public ResponseEntity<ProductosEntity> updateProducto(@PathVariable("id") Long id,
                                                          @RequestBody productoModel model) {

        ProductosEntity producto = productosRepository.findAllById(id);
        if (producto != null) {
            ProductosEntity productosEntity = new ProductosEntity();

            productosEntity.setId(id);
            productosEntity.setNombre(model.getNombre());
            productosEntity.setDescripcion(model.getDescripcion());
            productosEntity.setImagen(model.getImagen());
            productosEntity.setPrecio(model.getPrecio());
            productosRepository.save(productosEntity);

            return new ResponseEntity<ProductosEntity>(productosEntity, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<ProductosEntity>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/deleteProducto/{id}")
    public ResponseEntity<ProductosEntity> deleteProducto(@PathVariable("id") Long id) {

        ProductosEntity producto = productosRepository.findAllById(id);
        if (producto != null) {
            productosRepository.deleteAllById(producto.getId());
            return new ResponseEntity<ProductosEntity>(producto, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<ProductosEntity>(HttpStatus.NOT_FOUND);
        }

    }

}
