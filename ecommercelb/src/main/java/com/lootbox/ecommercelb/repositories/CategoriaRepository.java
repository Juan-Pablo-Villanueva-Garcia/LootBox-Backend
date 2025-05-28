package com.lootbox.ecommercelb.repositories;

import java.util.Optional;

import com.lootbox.ecommercelb.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	Optional<Categoria> findByNombre(String nombre);
}// interface CateogriaRepository
