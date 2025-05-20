package com.lootbox.ecommercelb.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.lootbox.ecommercelb.services.PedidosService;

@Controller
@RequestMapping("/api/pedidos/")

public class PedidosController {
	
	private final PedidosService pedidosService;
	
	@Autowired
	public PedidosController() {
		pedidosService = new PedidosService();
	}//Constructor
	
	@GetMapping
	public ArrayList<Pedido> getPedidos() {
		return pedidosService.getPedidos();
	}
	
	@GetMapping(path="{pedidoID}")
	public Pedido getPedido(@PathParam("pedidoID") int id) {
		return PedidosService.getPedido(id);
	}
	
	
}
