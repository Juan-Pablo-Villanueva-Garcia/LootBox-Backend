package com.lootbox.ecommercelb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lootbox.ecommercelb.models.Producto;
import com.lootbox.ecommercelb.services.ProductsService;

@RestController
@RequestMapping(path="/api/prod/") // http://localhost:8080/api/prod/
public class ProductosController {
	
	private final ProductsService productsService; 
	
	@Autowired
	public ProductosController(ProductsService productsService) {
		this.productsService = productsService;
	}//ProductosController
	
	@GetMapping
	public List<Producto>getProductos(){
		return productsService.getProducts();
	}//getProductos
	
	@GetMapping(path ="{id}") // http://localhost:8080/api/prod/1
	public Producto getProducto(@PathVariable("id") Long id) {
		return productsService.getProduct(id);
	}//getProducto
	
	@PostMapping
	public Producto addProducto(@RequestBody Producto product) {
		return productsService.addProduct(product);
	}//addProducto
	
	@DeleteMapping(path = "{id}") // http://localhost:8080/api/prod/1
	public Producto deleteProducto(@PathVariable("id") Long id) {
		return productsService.deleteProduct(id);
	}//deleteProducto
	
	@PutMapping(path = "{id}") //  http://localhost:8080/api/prod/1
	public Producto updateProducto(@PathVariable("id") Long id,
			@RequestParam(required = false) String name,
	        @RequestParam(required = false) String imagen,
	        @RequestParam(required = false) String descripcion,
	        @RequestParam(required = false) String category,
	        @RequestParam(required = false) Double price,
	        @RequestParam(required = false) String JSON,
	        @RequestParam(required = false) Integer sku,
	        @RequestParam(required = false) Integer stock,
	        @RequestParam(required = false) Double costo,
	        @RequestParam (required = false) Long categoriaid) {
		return productsService.updateProduct(id, name, imagen, descripcion, category, price, JSON, sku, stock, costo, categoriaid);
	}//updateProducto
}//class ProductosController
