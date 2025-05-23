package com.lootbox.ecommercelb.dto;

public class ChangePassword {
	private String contraseña;
	private String ncontraseña;
	
	public ChangePassword(String contraseña, String ncontraseña) {
		super();
		this.contraseña = contraseña;
		this.ncontraseña = ncontraseña;
	}//constructor
	
	public ChangePassword() {}//constructorVacio

	public String getPassword() {
		return contraseña;
	}//getPassword

	public void setPassword(String contraseña) {
		this.contraseña = contraseña;
	}//setPassword

	public String getNpassword() {
		return ncontraseña;
	}//getNpassword

	public void setNpassword(String ncontraseña) {
		this.ncontraseña = ncontraseña;
	}//setNpassword

	@Override
	public String toString() {
		return "ChangePassword [contraseña=" + contraseña + ", ncontraseña=" + ncontraseña + "]";
	}//toString
	
	
}//class ChangePassword
