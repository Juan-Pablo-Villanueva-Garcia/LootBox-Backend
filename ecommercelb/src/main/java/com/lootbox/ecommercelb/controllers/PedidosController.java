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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lootbox.ecommercelb.dto.SolicitudPedidoDTO;
import com.lootbox.ecommercelb.models.Pedido;
import com.lootbox.ecommercelb.services.PedidosService;

@RestController
@CrossOrigin(origins ="*")//"https://arghero.github.io/LootBox"
@RequestMapping("/api/pedidos/")
public class PedidosController {
	
	private final PedidosService pedidosService;
	
	@Autowired
	public PedidosController(PedidosService pedidosService) {
		this.pedidosService  = pedidosService;
	}//Constructor
	
	@GetMapping
	public List<Pedido> getPedidos() {
		return pedidosService.getPedidos();
	}
	
	@GetMapping(path="{numeroPedido}")
	public Pedido getPedido(@PathVariable("numeroPedido") String numeroPedido) {
		return pedidosService.getPedido(numeroPedido);
	}
	
	@DeleteMapping(path="{numeroPedido}")
	public Pedido deletePedido(@PathVariable("numeroPedido") String numeroPedido) {
		return pedidosService.deletePedido(numeroPedido);
	}
	
	@PostMapping
	public Pedido createPedido(@RequestBody SolicitudPedidoDTO solicitudPedidoDTO) {
		return pedidosService.createPedido(solicitudPedidoDTO);
	}//createPedido()
	
	@PutMapping(path="{numeroPedido}")
	public Pedido updatePedido(
			@PathVariable("numeroPedido") String numeroPedido,  
			@RequestParam(required = true) String status
			){
		return pedidosService.updatePedido(numeroPedido,status);
	}//updatePedido()
	
}//Class PedidosController
