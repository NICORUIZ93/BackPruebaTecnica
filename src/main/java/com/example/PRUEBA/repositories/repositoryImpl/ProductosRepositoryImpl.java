package com.example.PRUEBA.repositories.repositoryImpl;

import com.example.PRUEBA.entities.ProductosEntity;
import com.example.PRUEBA.models.ProductoModel;
import com.example.PRUEBA.repositories.ProductosRepository;
import com.example.PRUEBA.repositories.repositoryCustom.ProductosRepositoryCustom;
import com.example.PRUEBA.services.ConvertImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

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
            productosEntity.setImagen(imageConvert.conversionToByte(model.getImagen()));
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
        productosEntity.setImagen(imageConvert.conversionToByte(model.getImagen()));
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
    public ResponseEntity<List<ProductoModel>> productosFindAll() {
        List<ProductosEntity> productos = productosRepository.findAll();
        List<ProductoModel> productosFinal = new ArrayList<ProductoModel>();
        ProductoModel model = new ProductoModel();

        for (ProductosEntity productosEntity : productos) {
            model.setId(productosEntity.getId());
            model.setNombre(productosEntity.getNombre());
            model.setDescripcion(productosEntity.getDescripcion());
            model.setPrecio(productosEntity.getPrecio());
            model.setImagen(imageConvert.conversionToString(productosEntity.getImagen()));
            productosFinal.add(model);
        }

        return new ResponseEntity<>(productosFinal, HttpStatus.CREATED);
    }

}
