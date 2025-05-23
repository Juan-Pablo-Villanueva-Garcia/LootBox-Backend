package com.lootbox.ecommercelb.services;

import java.util.List;
import java.util.Optional;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lootbox.ecommercelb.models.Pedido;
import com.lootbox.ecommercelb.repositories.PedidosRepository;


@Service
public class PedidosService {
	//private final ArrayList<Pedido> pedidos = new ArrayList<Pedido>();
	//private final List<Pedido> pedidos = new ArrayList<Pedido>();
	//private final SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	PedidosRepository pedidosRepository;
	
	@Autowired
	public PedidosService(PedidosRepository pedidosRepository) {
		this.pedidosRepository = pedidosRepository;
//		pedidos.add(new Pedido(formato.parse("2025-05-02 09:15:00") , 1L, 2500.00, "Enviado"));
//        pedidos.add(new Pedido(formato.parse("2025-05-02 09:15:00"), 2L, 8499.99, "Pendiente"));
//        pedidos.add(new Pedido(formato.parse("2025-05-03 16:00:00"), 1L, 1350.49, "Entregado"));
//        pedidos.add(new Pedido(formato.parse("2025-05-04 11:45:00"), 3L, 245.00, "Cancelado"));
//        pedidos.add(new Pedido(formato.parse("2025-05-05 17:10:00"), 4L, 9999.99, "En proceso"));
//        pedidos.add(new Pedido(formato.parse("2025-05-06 13:20:00"), 2L, 999.00, "Enviado"));
//        pedidos.add(new Pedido(formato.parse("2025-05-07 10:05:00"), 5L, 4590.00, "Pendiente"));
//        pedidos.add(new Pedido(formato.parse("2025-05-08 18:40:00"), 3L, 7549.00, "Entregado"));
//        pedidos.add(new Pedido(formato.parse("2025-05-09 15:30:00"), 4L, 8499.99, "Cancelado"));
//        pedidos.add(new Pedido(formato.parse("2025-05-10 12:00:00"), 4L, 3750.00, "En proceso"));
	}//Constructor

	public List<Pedido> getPedidos() {
		return pedidosRepository.findAll();
	}//getPedidos()

	public Pedido getPedido(Long id) {
		
		Optional<Pedido> pedido = pedidosRepository.findById(id);
		if(pedido.isEmpty())
			return null;
		return pedido.get();
		
	}//getPedido()

	public Pedido deletePedido(Long id) {
		
		Optional<Pedido> pedido = pedidosRepository.findById(id);
		if(pedido.isEmpty())
			return null;
		Pedido temporal = pedido.get();
		pedidosRepository.deleteById(id);
		return temporal;

	}//deletePedido()

	public Pedido createPedido(Pedido pedido) {
		
		Long idUsuario = pedido.getIdUsuario();
		Date pedidoAt = pedido.getPedidoAt();
		
		Optional<Pedido> consulta = pedidosRepository.findByIdUsuario(idUsuario);
		
		if(consulta.isPresent() && pedidoAt.equals(consulta.get().getPedidoAt()))
			return null;
		pedidosRepository.save(pedido);
		return pedido;
		
	}//createPedido()
	
	public Pedido updatePedido(Long id, String status){
		
		Optional<Pedido> consulta = pedidosRepository.findById(id);
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
