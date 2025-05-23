package com.lootbox.ecommercelb.services;


import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lootbox.ecommercelb.dto.ChangePassword;
import com.lootbox.ecommercelb.models.Usuarios;
import com.lootbox.ecommercelb.repositories.UsuarioRepository;

@Service
public class UsuariosService {
	
	@Autowired
	private PasswordEncoder encoder;
	public final UsuarioRepository usuarioRepository;
	
//	private final List<Usuarios> lista = new ArrayList<Usuarios>();

//	public UsuariosService() {
//		//String nombre, String descripcion, String imagen, Double precio, String direccion
//		lista.add(new Usuarios("Jazmin Bethzabe Robles Macias", "popotes@gmial.com", "3325201943","popotes1234","asdfasdf"));
//		lista.add(new Usuarios("Carlos Eduardo Sánchez Pérez", "carlossanchez@gmail.com", "5512345678", "carlos2025","asdfasdf"));
//		lista.add(new Usuarios("Luis Alberto Torres Ramírez", "luis.torres@yahoo.com", "3399887766", "luistorres99","asdfasdf"));
//	}//constructor
	
	@Autowired
	public UsuariosService(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	public List<Usuarios> getUsuarios() {
		return usuarioRepository.findAll();
	}//getUsuarios
	public Usuarios getUsuario(Long id) {
		Usuarios tmp = null;
		if(usuarioRepository.existsById(id)) {
			tmp = usuarioRepository.findById(id).get();
		}//if	
	return tmp;
	}//getUsuario
	public Usuarios addUsuario(Usuarios usuario) {
		 Optional<Usuarios> user = usuarioRepository.findByEmail(usuario.getEmail());
		 if(user.isEmpty()) {
			 usuario.setContraseña( encoder.encode(usuario.getContraseña()));
			 usuarioRepository.save(usuario);
		 }else {
			 usuario = null;
		 }
		return usuario;
	}//addUsuario
	public Usuarios deletUsuario(Long id) {
		Usuarios tmp =null;
		if(usuarioRepository.existsById(id)) {
			tmp = usuarioRepository.findById(id).get();
			usuarioRepository.deleteById(id);
		}//ifExist
		return tmp;
	}//deletUsuario

	public Usuarios updateUsuario(Long id, ChangePassword changePassword) {
		Usuarios user = null;
		 if (usuarioRepository.existsById(id)) {
		        user = usuarioRepository.findById(id).get();
		        if (encoder.matches(changePassword.getPassword(), user.getContraseña())) {
		            user.setContraseña(encoder.encode(changePassword.getNpassword()));
		            usuarioRepository.save(user);
		        } else {
		            user = null;
		        }//matches
		    }//existsbyId
		
		return user;
	}//updateUsuario

	public boolean validateUser(Usuarios usuario) {
		Optional<Usuarios> user = usuarioRepository.findByEmail(usuario.getEmail());
		if(user.isPresent()) {
			Usuarios tmp = user.get();
			if(encoder.matches(usuario.getContraseña(), tmp.getContraseña())) return true;//matches
		}///isPresent
		return false;
	}//validateUser
}//class UsuarioService
