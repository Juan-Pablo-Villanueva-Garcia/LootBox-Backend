package com.lootbox.ecommercelb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lootbox.ecommercelb.models.Producto;
import com.lootbox.ecommercelb.repositories.ProductsRepository;

@Service
public class ProductsService {
	private final ProductsRepository productsRepository;

	@Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }//constructor

	public List<Producto> getProducts() {
		return productsRepository.findAll();
	}//getProducts
	
	public Producto getProduct(Long id) {
		return productsRepository.findById(id)
				.orElseThrow(()-> new IllegalArgumentException("Producto con ID [" + id + "] no encontrado."));
	}//getProduct

	public Producto addProduct(Producto producto) {
		Optional<Producto> prod = productsRepository.findByName(producto.getName());
		if (prod.isEmpty()) {
			return productsRepository.save(producto);
		}//if isEmpty
		return null;
	}//addProduct

	public Producto deleteProduct(Long id) {
		Producto tmp = null;
		if (productsRepository.existsById(id)) {
			tmp = productsRepository.findById(id).get();
			productsRepository.deleteById(id);
		}//if exists
		return tmp;
	}//deleteProduct

	public Producto updateProduct(Long id, String name, String imagen, String descripcion, String category, Double price, String jSON, Integer sku, Integer stock, Double costo, Long categoriaid) {
		Producto tmp = null;
		if(productsRepository.existsById(id)) {
			if (productsRepository.existsById(id)) {
				Producto producto = productsRepository.findById(id).get();
				if (name!= null) producto.setName(name);
				if (imagen!= null) producto.setImagen(imagen);
				if (descripcion!= null) producto.setDescripcion(descripcion);
				if (category!= null) producto.setCategory(category);
				if (price!= null) producto.setPrice(price);
				if (jSON!= null) producto.setJSON(jSON);
				if (sku!= null) producto.setSku(sku);
				if (stock!= null) producto.setStock(stock);
				if (costo!= null) producto.setCosto(costo);
				if (categoriaid!= null) producto.setCategoriaid(categoriaid);
				tmp = producto;
			}//if
		}//for
		return tmp;
	}//updateProduct
}//class ProductsService
