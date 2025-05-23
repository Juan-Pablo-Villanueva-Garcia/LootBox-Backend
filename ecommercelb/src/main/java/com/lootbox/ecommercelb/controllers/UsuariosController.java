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
import com.lootbox.ecommercelb.models.Usuarios;
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
	public List<Usuarios> getUsiaros(){
		return usuariosService.getUsuarios();
	}//getUsiaros
	@GetMapping(path="{usuarioId}")//http://localhost:8080/api/usuarios/1
	public Usuarios getUsuario(@PathVariable("usuarioId")Long id){
		return usuariosService.getUsuario(id);
	}//getUsiaro
	@PostMapping//http://localhost:8080/api/usuarios
	public Usuarios addUsuario(@RequestBody Usuarios usuario) {
		return usuariosService.addUsuario(usuario);
	}//addUsuario
	@DeleteMapping(path="{usuarioId}")//http://localhost:8080/api/usuarios/1
	public Usuarios deletUsuario(@PathVariable("usuarioId")Long id) {
		return usuariosService.deletUsuario(id);
	}//deletUsuario
	@PutMapping(path="{usuarioId}")//http://localhost:8080/api/usuarios/1
	public Usuarios updateUsuario(@PathVariable("idUsuario")Long id,
			@RequestBody ChangePassword changePassword) {
		return usuariosService.updateUsuario(id,changePassword);
	}//updateUsuario
}//class UsuariosController
