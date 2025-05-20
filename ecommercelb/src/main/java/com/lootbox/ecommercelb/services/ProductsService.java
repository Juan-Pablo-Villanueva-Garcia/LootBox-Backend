package com.lootbox.ecommercelb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lootbox.ecommercelb.models.Products;

@Service
public class ProductsService {
	private final List<Products> lista = new ArrayList<>();

    public ProductsService() {
        lista.add(new Products(
            "LootBox Legendaria",
            "https://res.cloudinary.com/dsjcemt6v/image/upload/v1747185375/Lootbox-G_nwkhoc.webp",
            "solo para los que se atreven a todo. El drop más épico, con ítems sorpresa de otro nivel.",
            "0",
            6000.00,
            "{\"rate\": 4.9, \"count\": 1300}",
            1120,
            349,
            5400.00
        ));

        lista.add(new Products(
            "PlayStation 5",
            "https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963956/619BkvKW35L._AC_SL1500__oj8efg.jpg",
            "Consola de nueva generación con soporte para 4K y SSD ultrarrápido.",
            "1",
            9999.99,
            "{\"rate\": 4.8, \"count\": 852}",
            2384,
            112,
            8999.99
        ));

        lista.add(new Products(
            "Xbox Series X",
            "https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963956/61JGKhqxHxL._AC_SL1500__dyv4k2.jpg",
            "La consola más potente de Microsoft con 1TB SSD y 12 teraflops.",
            "1",
            8499.99,
            "{\"rate\": 4.7, \"count\": 713}",
            2591,
            74,
            7649.99
        ));

        lista.add(new Products(
            "Nintendo Switch OLED",
            "https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/71Q54HnKxwS._AC_SX522__cou4wb.jpg",
            "Consola híbrida con pantalla OLED de 7 pulgadas y mejor audio.",
            "1",
            6899.99,
            "{\"rate\": 4.6, \"count\": 631}",
            2723,
            186,
            6209.99
        ));

        lista.add(new Products(
            "Steam Deck",
            "https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963953/images_wp8jdt.jpg",
            "Consola portátil de Valve para juegos de PC en cualquier lugar.",
            "1",
            7549.00,
            "{\"rate\": 4.5, \"count\": 298}",
            2944,
            37,
            6794.10
        ));
    }//constructor

	public List<Products> getProducts() {
		return lista;
	}//getProducts
	
	public Products getProduct(Long id) {
		for (Products producto : lista) {
			if(producto.getIdProductos().equals(id)) {
				return producto;
			}//if
		}//for
		return null;
	}//getProduct

	public Products addProduct(Products producto) {
		lista.add(producto);
		return producto;
	}//addProduct

	public Products deleteProduct(Long id) {
		Products tmp = null;
		for (Products producto : lista) {
			if(producto.getIdProductos().equals(id)) {
				tmp = producto;
				lista.remove(producto);
			}//if
		}//for
		return tmp;
	}//deleteProduct

	public Products updateProduct(Long id, String name, String imagen, String descripcion, String category,
			Double price, String jSON, Integer sku, Integer stock, Double costo) {
		
		Products tmp = null;
		for (Products producto : lista) {
			if (producto.getIdProductos().equals(id)) {
				if (name!= null) producto.setName(name);
				if (imagen!= null) producto.setImagen(imagen);
				if (descripcion!= null) producto.setDescripcion(descripcion);
				if (category!= null) producto.setCategory(category);
				if (price!= null) producto.setPrice(price);
				if (jSON!= null) producto.setJSON(jSON);
				if (sku!= null) producto.setSku(sku);
				if (stock!= null) producto.setStock(stock);
				if (costo!= null) producto.setCosto(costo);
				tmp = producto;
				break;
			}//if
		}//for
		return tmp;
	}//updateProduct
}//class ProductsService
