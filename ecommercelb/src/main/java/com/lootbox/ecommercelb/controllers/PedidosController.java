package com.lootbox.ecommercelb.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lootbox.ecommercelb.models.Pedido;
import com.lootbox.ecommercelb.services.PedidosService;

@Controller
@RequestMapping("/api/pedidos/")
public class PedidosController {
	
	private final PedidosService pedidosService;
	
	@Autowired
	public PedidosController() throws ParseException {
		pedidosService = new PedidosService();
	}//Constructor
	
	
	
	@GetMapping
	public List<Pedido> getPedidos() {
		return pedidosService.getPedidos();
	}
	
	@GetMapping(path="{pedidoID}")
	public Pedido getPedido(@PathParam("pedidoID") Long id) {
		return pedidosService.getPedido(id);
	}
	
	
}
