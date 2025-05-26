package com.lootbox.ecommercelb.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lootbox.ecommercelb.models.Producto;

public interface ProductsRepository extends JpaRepository<Producto, Long> {
    Optional<Producto> findByName(String name);
}//interface ProductsRepository