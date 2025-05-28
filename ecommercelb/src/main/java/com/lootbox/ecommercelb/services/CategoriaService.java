package com.lootbox.ecommercelb.services;

import java.util.List;
import java.util.Optional;

import com.lootbox.ecommercelb.models.Categoria;
import com.lootbox.ecommercelb.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {
	public final CategoriaRepository categoriaRepository;
	
	@Autowired
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}//constructor
	
	public List<Categoria> getAllCategorias(){
		return categoriaRepository.findAll();
	}//getAllCategorias
	public Categoria getCategoria(Long id) {
		return categoriaRepository.findById(id).orElseThrow(
	()-> new IllegalArgumentException("La Categoría con el id" + id
			+ "] no existe"));
	}
	
	public Categoria deleteCategoria(Long id) {
		Categoria cat = null;
		if(categoriaRepository.existsById(id)) {
			cat = categoriaRepository.findById(id).get();
			categoriaRepository.deleteById(id);
		}//exists
		return cat;
	}//deleteCategoria
	
	public Categoria addCategoria(Categoria categoria) {
		
		Optional<Categoria> cat = categoriaRepository.findByNombre(categoria.getNombre());
		if (cat.isEmpty()) {
			return categoriaRepository.save(categoria);
		} else {
			System.out.println("La categoria ["+ categoria.getNombre()
		+ "]ya se encuentra registrada");
		return null;
		}//else
	}//addCategoria
	
	public Categoria updateCategoria(Long id, String nombre, String descripcion) {
		Categoria cat =null;
		if(categoriaRepository.existsById(id)) {
			cat = categoriaRepository.findById(id).get();
			if(nombre!=null)cat.setNombre(nombre);
			if(descripcion!=null)cat.setDescripcion(descripcion);
			categoriaRepository.save(cat);
			}//exists
		return cat;
	}//updateCategoria

}//class CategoriaService