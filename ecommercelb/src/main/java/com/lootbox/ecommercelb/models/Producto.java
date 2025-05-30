package com.lootbox.ecommercelb.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;//clase wrapper
	
	@Column(nullable = false)
	private String name;
	private String imagen;
	private String descripcion;
	private String category;
	@Column(nullable = false)
	private Double price;//clase wrapper
	private String JSON;
	@Column(unique = true)
	private Integer sku;
	@Column(nullable = false)
	private Integer stock;
	private Double costo;
	@Column(nullable=false)
	private Long categoriaid;
//	private static Long total = Long.valueOf(0);
//	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<PedidoshasProduct> pedidos_has_product = new HashSet<>();
	@ManyToMany(mappedBy = "productos")
    private Set<Pedido> pedidos = new HashSet<>();
	
	public Producto () {
	} //Constructor vacio
	
	public Producto(String name, String imagen, String descripcion, String category, Double price, String jSON,
			Integer sku, Integer stock, Double costo, Long categoriaid) {
		
		this.name = name;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.category = category;
		this.price = price;
		this.JSON = jSON;
		this.sku = sku;
		this.stock = stock;
		this.costo = costo;
		this.categoriaid = categoriaid;
//		Producto.total++;
//		this.id = Producto.total;
	}//Constructor con campos
	

	//Getters and Setters
	

	public Long getCategoriaid() {
		return categoriaid;
	}//getCategoriaid
	public void setCategoriaid(Long categoriaid) {
		this.categoriaid = categoriaid;
	}//setCategoriaid
	public String getName() {
		return name;
	}//getName
	public void setName(String name) {
		this.name = name;
	}//setName
	public String getImagen() {
		return imagen;
	}//getImagen
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}//setImagen
	public String getDescripcion() {
		return descripcion;
	}//getDescripcion
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion
	public String getCategory() {
		return category;
	}//getCategory
	public void setCategory(String category) {
		this.category = category;
	}//setCategory
	public Double getPrice() {
		return price;
	}//getPrice
	public void setPrice(Double price) {
		this.price = price;
	}//setPrice
	public String getJSON() {
		return JSON;
	}//getJSON
	public void setJSON(String jSON) {
		JSON = jSON;
	}//setJSON
	public Integer getSku() {
		return sku;
	}//getSku
	public void setSku(Integer sku) {
		this.sku = sku;
	}//setSku
	public Integer getStock() {
		return stock;
	}//getStock
	public void setStock(Integer stock) {
		this.stock = stock;
	}//setStock
	public Double getCosto() {
		return costo;
	}//getCosto
	public void setCosto(Double costo) {
		this.costo = costo;
	}//setCosto
	public Long getId() {
		return id;
	}//getIdProductos
	
	public Set<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(Set<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", name=" + name + ", imagen=" + imagen + ", descripcion=" + descripcion
				+ ", category=" + category + ", price=" + price + ", JSON=" + JSON + ", sku=" + sku + ", stock=" + stock
				+ ", costo=" + costo + ", categoriaid=" + categoriaid + ", pedidos=" + pedidos + "]";
	}

	
	
}//class Products
