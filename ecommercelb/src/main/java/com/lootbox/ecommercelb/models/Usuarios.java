package com.lootbox.ecommercelb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuarios {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",unique = true, nullable = false)
	private Long idUsuario;//clase wrapper
	@Column(nullable = false)
	private String nombre;
	@Column(nullable = false)
	private String email;
	@Column(nullable = false)
	private String telefono;
	@Column(nullable = false)
	private String contraseña;//clase wrapper
	@Column(nullable = false)
	private String direccion;
	@Column(nullable = false)
	private Boolean isAdmin;
	public Usuarios(String nombre, String email, String telefono, String contraseña, String direccion) {
		
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.isAdmin = false;
	}//constructor con campos
	
	public Usuarios () {} //constructor vacío

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

	public String getContraseña() {
		return contraseña;
	}//getContraseña

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}//setContraseña

	public Long getIdUsuario() {
		return idUsuario;
	}//getidUsuario

	@Override
	public String toString() {
		return "Usuarios [idUsuario=" + idUsuario + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono
				+ ", contraseña=" + contraseña + ", direccion=" + direccion + ", isAdmin=" + isAdmin + "]";
	}//toString
			
}//class Usuarios



