package com.example.PRUEBA.repositories;

import com.example.PRUEBA.entities.ProductosEntity;
import com.example.PRUEBA.models.productoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity, Long> {

    ProductosEntity findAllById(Long id);

    void save(productoModel model);

    void deleteAllById(Long id);

}
