package com.lootbox.ecommercelb.models;

public class Usuarios {
	private Long idUsuario;//clase wrapper
	private String nombre;
	private String email;
	private String telefono;
	private String contraseña;//clase wrapper
	private String direccion;
	private Boolean isAdmin;
	private static Long total = Long.valueOf(0);
	public Usuarios(String nombre, String email, String telefono, String contraseña, String direccion) {
		
		this.nombre = nombre;
		this.email = email;
		this.telefono = telefono;
		this.contraseña = contraseña;
		this.direccion = direccion;
		this.isAdmin = false;
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



