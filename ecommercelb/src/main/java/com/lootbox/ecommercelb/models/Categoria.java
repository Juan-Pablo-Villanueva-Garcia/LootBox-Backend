package com.lootbox.ecommercelb.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id", unique= true, nullable = false)
	private Long id;
	@Column(nullable = false)
	private String nombre;
	private String descripcion;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "categoriaid", referencedColumnName= "id")
	List<Producto> productos = new ArrayList<Producto>();
	
	public Categoria(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}//Constructor con campos
	
	public Categoria() {
		
	}//Constructor vacío

	public List<Producto> getProductos() {
		return productos;
	}//getProductos

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getDescripcion() {
		return descripcion;
	}//getDescripcion

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}//setDescripcion

	public Long getId() {
		return id;
	}//getId

	@Override
	public String toString() {
		return "Categoría [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}//toString
	
	
	
}//class Categoria
