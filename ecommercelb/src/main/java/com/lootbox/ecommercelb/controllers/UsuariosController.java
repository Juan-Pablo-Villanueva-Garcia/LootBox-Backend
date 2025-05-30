package com.lootbox.ecommercelb.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins ="*")//"https://arghero.github.io/LootBox"

public class UsuariosController {

    private final UsuariosService usuariosService;

    @Autowired
    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuariosService.getUsuarios();
    }

    @GetMapping(path="{usuarioId}")
    public Usuario getUsuario(@PathVariable("usuarioId") Long id) {
        return usuariosService.getUsuario(id);
    }

    @PostMapping
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return usuariosService.addUsuario(usuario);
    }

    @PostMapping("registro")
    public Usuario registrarUsuario(@RequestBody Usuario usuario) {
        return usuariosService.addUsuario(usuario);
    }

    @DeleteMapping(path="{usuarioId}")
    public Usuario deleteUsuario(@PathVariable("usuarioId") Long id) {
        return usuariosService.deletUsuario(id);
    }

    @PutMapping(path="{usuarioId}")
    public Usuario updateUsuario(@PathVariable("usuarioId") Long id,
                                 @RequestBody ChangePassword changePassword) {
        return usuariosService.updateUsuario(id, changePassword);
    }
}
