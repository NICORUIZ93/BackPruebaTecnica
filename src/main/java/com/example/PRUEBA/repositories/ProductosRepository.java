package com.example.PRUEBA.repositories;

import com.example.PRUEBA.entities.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductosRepository extends JpaRepository<ProductosEntity, Long> {

}
