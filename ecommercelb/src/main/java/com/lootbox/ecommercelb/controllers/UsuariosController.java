package com.lootbox.ecommercelb.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lootbox.ecommercelb.dto.ChangePassword;
import com.lootbox.ecommercelb.models.Usuario;
import com.lootbox.ecommercelb.services.UsuariosService;

@RestController
@RequestMapping(path="/api/usuarios/")//http://localhost:8080/api/usuarios
public class UsuariosController {

	private final UsuariosService usuariosService;
	
	@Autowired
	public UsuariosController(UsuariosService usuariosService) {
		super();
		this.usuariosService = usuariosService;
	}//UsuariosController
	
	@GetMapping 
	public List<Usuario> getUsiaros(){
		return usuariosService.getUsuarios();
	}//getUsiaros
	@GetMapping(path="{usuarioId}")//http://localhost:8080/api/usuarios/1
	public Usuario getUsuario(@PathVariable("usuarioId")Long id){
		return usuariosService.getUsuario(id);
	}//getUsiaro
	@PostMapping//http://localhost:8080/api/usuarios
	public Usuario addUsuario(@RequestBody Usuario usuario) {
		return usuariosService.addUsuario(usuario);
	}//addUsuario
	@DeleteMapping(path="{usuarioId}")//http://localhost:8080/api/usuarios/1
	public Usuario deletUsuario(@PathVariable("usuarioId")Long id) {
		return usuariosService.deletUsuario(id);
	}//deletUsuario
	@PutMapping(path="{usuarioId}")//http://localhost:8080/api/usuarios/1
	public Usuario updateUsuario(@PathVariable("usuarioId")Long id,
			@RequestBody ChangePassword changePassword) {
		return usuariosService.updateUsuario(id,changePassword);
	}//updateUsuario
}//class UsuariosController
