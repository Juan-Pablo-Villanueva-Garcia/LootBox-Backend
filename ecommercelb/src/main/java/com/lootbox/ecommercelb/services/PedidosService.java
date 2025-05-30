package com.lootbox.ecommercelb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lootbox.ecommercelb.models.Pedido;
import com.lootbox.ecommercelb.repositories.PedidosRepository;


@Service
public class PedidosService {
	PedidosRepository pedidosRepository;
	
	@Autowired
	public PedidosService(PedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
	}//Constructor

	public List<Pedido> getPedidos() {
		return pedidosRepository.findAll();
	}//getPedidos()

	public Pedido getPedido(String numeroPedido) {
		
		Optional<Pedido> pedido = pedidosRepository.findByNumeroPedido(numeroPedido);
		if(pedido.isEmpty())
			return null;
		return pedido.get();
		
	}//getPedido()

	public Pedido deletePedido(String numeroPedido) {
		
		Optional<Pedido> pedido = pedidosRepository.findByNumeroPedido(numeroPedido);
		if(pedido.isEmpty())
			return null;
		Pedido temporal = pedido.get();
		pedidosRepository.deleteByNumeroPedido(numeroPedido);
		return temporal;

	}//deletePedido()

	public Pedido createPedido(Pedido pedido) {
		Optional<Pedido> consulta = pedidosRepository.findByNumeroPedido(pedido.getNumeroPedido());
		if(consulta.isPresent())
			return null;
		pedidosRepository.save(pedido);
		return pedido;
		
	}//createPedido()
	
	public Pedido updatePedido(String numeroPedido, String status){
		
		Optional<Pedido> consulta = pedidosRepository.findByNumeroPedido(numeroPedido);
		if(consulta.isEmpty())
			return null;
		Pedido pedido = consulta.get();
		//if(fecha!=null) pedido.setPedido(fecha);
		pedido.setStatus(status);
		//if(precioTotal!=null) pedido.setPrecioTotal(precioTotal);
		pedidosRepository.save(pedido);
		return pedido;
	}//getPedido()
	
	
}//Class PedidosService
