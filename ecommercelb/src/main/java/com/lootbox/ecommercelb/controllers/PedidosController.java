package com.lootbox.ecommercelb.controllers;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lootbox.ecommercelb.models.Pedido;
import com.lootbox.ecommercelb.services.PedidosService;

@RestController
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
	public Pedido getPedido(@PathVariable("pedidoID") Long id) {
		return pedidosService.getPedido(id);
	}
	
	@DeleteMapping(path="{pedidoID}")
	public Pedido deletePedido(@PathVariable("pedidoID") Long id) {
		return pedidosService.deletePedido(id);
	}
	
	@PostMapping
	public Pedido createPedido(@RequestBody Pedido pedido) {
		return pedidosService.createPedido(pedido);
	}//createPedido()
	
	@PutMapping(path="{pedidoID}")
	public Pedido updatePedido(
			@PathVariable("pedidoID") Long id,  
			@RequestParam(required = false) Date pedidoAt, 
			@RequestParam(required = false) Double precioTotal, 
			@RequestParam(required = false) String status
			) throws ParseException{
		return pedidosService.updatePedido(id,pedidoAt,precioTotal,status);
	}//updatePedido()
	
}//Class PedidosController
