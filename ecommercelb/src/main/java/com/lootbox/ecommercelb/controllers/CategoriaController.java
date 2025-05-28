package com.lootbox.ecommercelb.controllers;

import java.util.List;

import com.lootbox.ecommercelb.models.Categoria;
import com.lootbox.ecommercelb.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins ="*")//"https://arghero.github.io/LootBox"
@RequestMapping(path = "/api/categorias")
@RestController
public class CategoriaController {
	
	private final CategoriaService categoriaService;
	
	@Autowired
	public CategoriaController(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}//constructor
	
	@GetMapping
	public List<Categoria> getCategorias(){
		return categoriaService.getAllCategorias();
	}
	@GetMapping(path="{id}")
	public Categoria getCategoria(@PathVariable("id") Long id){
		return categoriaService.getCategoria(id);
	}
	
	@PostMapping(path= "{id}")
	public Categoria addCategoria(@RequestBody Categoria categoria) {
		return categoriaService.addCategoria(categoria);
	}
	@DeleteMapping(path= "{id}")
	public Categoria deleteCategoria(@PathVariable("id")Long id) {
		return categoriaService.deleteCategoria(id);
	}
	@PutMapping(path= "{id}")
	public Categoria updateCategoria(@PathVariable("id") Long id,
			@RequestParam (required = false) String nombre,
			@RequestParam (required = false) String descripcion) {
		return categoriaService.updateCategoria(id, nombre, descripcion);
	}//updateCategoria
	

}//CategoriaController
