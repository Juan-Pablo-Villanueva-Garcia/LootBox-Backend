package com.lootbox.ecommercelb.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lootbox.ecommercelb.models.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
    Optional<Products> findByName(String name);
}//interface ProductsRepository