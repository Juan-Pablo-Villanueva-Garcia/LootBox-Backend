package com.lootbox.ecommercelb.models;

public class Usuarios {
	private Long idUsuario;//clase wrapper
	private String nombre;
	private String email;
	private String telefono;
	private String contraseña;//clase wrapper
	private static Long total = Long.valueOf(0);
	public Usuarios(String nombre, String email, String telefono, String contraseña) {
		
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;
		Usuarios.total++;
		this.idUsuario = Usuarios.total;
	}//constructor con campos
	
	public Usuarios () {
		Usuarios.total++;
		this.idUsuario = Usuarios.total;
	} //constructor vacío

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
				+ ", contraseña=" + contraseña + "]";
	}//toString
	
	
	
}//class Usuarios



