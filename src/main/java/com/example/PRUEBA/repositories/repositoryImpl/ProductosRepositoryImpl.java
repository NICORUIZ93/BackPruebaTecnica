package com.example.PRUEBA.repositories.repositoryImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.PRUEBA.entities.ProductosEntity;
import com.example.PRUEBA.models.ProductoModel;
import com.example.PRUEBA.repositories.ProductosRepository;
import com.example.PRUEBA.repositories.repositoryCustom.ProductosRepositoryCustom;
import com.example.PRUEBA.services.ConvertImage;

@Service
public class ProductosRepositoryImpl implements ProductosRepositoryCustom {

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ConvertImage imageConvert;

    @Override
    public ResponseEntity<ProductosEntity> actualizar(Long id, ProductoModel model) {

        Optional<ProductosEntity> producto = productosRepository.findById(id);

        if (producto != null) {
            ProductosEntity productosEntity = new ProductosEntity();

            productosEntity.setId(id);
            productosEntity.setNombre(model.getNombre());
            productosEntity.setDescripcion(model.getDescripcion());
            productosEntity.setImagen(imageConvert.conversionBase64(model.getImagen()));
            productosEntity.setPrecio(model.getPrecio());
            productosRepository.save(productosEntity);

            return new ResponseEntity<ProductosEntity>(productosEntity, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<ProductosEntity>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<ProductosEntity> IngresarProducto(ProductoModel model) {

        ProductosEntity productosEntity = new ProductosEntity();

        productosEntity.setNombre(model.getNombre());
        productosEntity.setDescripcion(model.getDescripcion());
        productosEntity.setImagen(imageConvert.conversionBase64(model.getImagen()));
        productosEntity.setPrecio(model.getPrecio());

        productosRepository.save(productosEntity);

        return new ResponseEntity<ProductosEntity>(productosEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<ProductosEntity> eliminarProducto(Long id) {

        if (productosRepository.findById(id) != null) {
            productosRepository.deleteById(id);
            return new ResponseEntity<ProductosEntity>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<ProductosEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<ProductosEntity>> productosFindAll() {
        List<ProductosEntity> productos = productosRepository.findAll();

        for (ProductosEntity productosEntity2 : productos) {

            productosEntity2.setImagen(Arrays.toString(productosEntity2.getImagen()));
            productos.add(productosEntity2);

        }

        List<ProductosEntity> productosEntityFinal = productos;

        return new ResponseEntity<>(productosEntityFinal, HttpStatus.CREATED);
    }

}
