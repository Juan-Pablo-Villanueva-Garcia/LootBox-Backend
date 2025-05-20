package com.lootbox.ecommercelb.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidosService {
	private final ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	
	@Autowired
	public PedidosService() {
		//pedidos.add(new Pedido ());
		
	}//Constructor
	

	public Pedido getPedidos() {
		// TODO Auto-generated method stub
		return pedidos;
	}//getPedidos()

	public static Pedido getPedido(int id) {
		for (Pedido pedido: pedidos) {
			if(pedido.id==id) {
				return pedido;
			}
		}
		return null;
	}//getPedido()
	
	

}
