package com.lootbox.ecommercelb.controllers;

import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lootbox.ecommercelb.models.Usuario;
import com.lootbox.ecommercelb.config.JwtFilter;
import com.lootbox.ecommercelb.dto.Token;
import com.lootbox.ecommercelb.services.UsuariosService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping(path="/api/login/")
public class LoginController {
	private final UsuariosService usuarioServicio;
	
	@Autowired
	public LoginController(UsuariosService usuarioservice) {
		this.usuarioServicio = usuarioservice;
	}//LoginController
	
	@PostMapping
	public Token loginUser(@RequestBody Usuario usuario) throws ServletException{
		if(usuarioServicio.validateUser(usuario)) {
			return new Token(generaToken(usuario.getEmail()));
		}//if validateUser
		throw new ServletException("Nombre de usuario o contraseña incorrectos["+usuario.getEmail()+"]");
		
	}//loginUser

	private String generaToken(String email) {
		Calendar calendar = Calendar.getInstance();
		//calendar.add(Calendar.MINUTE, 30);   // Dato más real
				calendar.add(Calendar.HOUR, 24); // Para pruebas
				
				return Jwts.builder().setSubject(email).claim("role", "user")
						.setIssuedAt(new Date())
						.setExpiration(calendar.getTime())
						.signWith(SignatureAlgorithm.HS256, JwtFilter.secret)
						.compact();
			}//generateToken
	
}
