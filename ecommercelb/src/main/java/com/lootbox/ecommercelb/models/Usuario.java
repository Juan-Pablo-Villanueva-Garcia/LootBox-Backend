package com.lootbox.ecommercelb.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique = true, nullable = false)
	private Long id;//clase wrapper
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String telefono;
	@Column(nullable = false)
	private String password;//clase wrapper
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private Boolean isAdmin = false;
	
	@OneToMany(mappedBy = "usuario" , cascade = CascadeType.ALL, orphanRemoval = true) //Clave foranea de usuario en pedidos
	private List<Pedido> pedidos;
	
	public Usuario(String nombre, String email, String telefono, String password, String direccion) {
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.password = password;
		this.direccion = direccion;
		this.isAdmin = false;
	}//constructor con campos
	
	public Usuario () {} //constructor vacío

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getEmail() {
		return email;
	}//getEmail

	public void setEmail(String email) {
		this.email = email;
	}//setEmail

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public String getDireccion() {
		return direccion;
	}//getDireccion

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}//setDireccion

	public Boolean getIsAdmin(Boolean isAdmin) {
		return isAdmin;
	}//setIsAdmin

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	public String getPassword() {
		return password;
	}//getContraseña

	public void setPassword(String password) {
		this.password = password;
	}//setContraseña

	public Long getId() {
		return id;
	}//getidUsuario

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", password=" + password + ", direccion=" + direccion + ", isAdmin=" + isAdmin + "]";
	}//toString
			
}//class Usuarios



