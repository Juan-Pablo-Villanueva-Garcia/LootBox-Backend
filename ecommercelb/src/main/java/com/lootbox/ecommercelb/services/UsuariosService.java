package com.lootbox.ecommercelb.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lootbox.ecommercelb.models.Usuarios;

@Service
public class UsuariosService {
	private final List<Usuarios> lista = new ArrayList<Usuarios>();
	@Autowired
	public UsuariosService() {
		//String nombre, String descripcion, String imagen, Double precio, String direccion
		lista.add(new Usuarios("Jazmin Bethzabe Robles Macias", "popotes@gmial.com", "3325201943","popotes1234","asdfasdf"));
		lista.add(new Usuarios("Carlos Eduardo Sánchez Pérez", "carlossanchez@gmail.com", "5512345678", "carlos2025","asdfasdf"));
		lista.add(new Usuarios("Luis Alberto Torres Ramírez", "luis.torres@yahoo.com", "3399887766", "luistorres99","asdfasdf"));
	}//constructor
	public List<Usuarios> getUsuarios() {
		return lista;
	}//getUsuarios
	public Usuarios getUsuario(Long id) {
		Usuarios tmp = null;
	for (Usuarios usuario : lista) {
		if(id == usuario.getIdUsuario()) {
			tmp = usuario;
			break;
		}//if
	}//forEach		
	return tmp;
	}//getUsuario
	public Usuarios addUsuario(Usuarios usuario) {
		lista.add(usuario);
		return usuario;
	}//addUsuario
	public Usuarios deletUsuario(Long id) {
		Usuarios tmp = null;
		for (Usuarios usuario : lista) {
			if(id == usuario.getIdUsuario()) {
				tmp = usuario;
				lista.remove(usuario);
				break;
			}//if
		}//forEach		
		return tmp;
	}//DeletUsuario
	public Usuarios updateUsuario(Long id, String nombre, String email, String telefono, String contraseña,String direccion) {
		Usuarios tmp = null;
		for (Usuarios usuario : lista) {
			if(id == usuario.getIdUsuario()) {
				if(nombre!=null)usuario.setNombre(nombre);
				if(email!=null)usuario.setEmail(email);
				if(telefono!=null)usuario.setTelefono(telefono);
				if(contraseña!=null)usuario.setContraseña(contraseña);
				if(direccion!=null)usuario.setContraseña(direccion);
				tmp=  usuario;
				break;
			}//if
		}//forEach
		return tmp;
	}//updateUsuario
}//class UsuarioService
