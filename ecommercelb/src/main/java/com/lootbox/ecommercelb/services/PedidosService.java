package com.lootbox.ecommercelb.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lootbox.ecommercelb.dto.PedidoProductosDTO;
import com.lootbox.ecommercelb.dto.SolicitudPedidoDTO;
import com.lootbox.ecommercelb.models.Pedido;
import com.lootbox.ecommercelb.models.Producto;
import com.lootbox.ecommercelb.models.Usuario;
import com.lootbox.ecommercelb.repositories.PedidosRepository;
import com.lootbox.ecommercelb.repositories.ProductsRepository;
import com.lootbox.ecommercelb.repositories.UsuarioRepository;


@Service
public class PedidosService {
	PedidosRepository pedidosRepository;
	ProductsRepository productosRepository;
	UsuarioRepository usuarioRepository;
	
	@Autowired
	public PedidosService(
			PedidosRepository pedidosRepository,
			ProductsRepository productosRepository,
			UsuarioRepository usuarioRepository) {
		
		this.pedidosRepository = pedidosRepository;
		this.productosRepository = productosRepository;
		this.usuarioRepository = usuarioRepository;
		
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

	@Transactional
	public Pedido createPedido(SolicitudPedidoDTO solicitudPedidoDTO) {
		Long usuarioId = solicitudPedidoDTO.getUsuarioid();
		Optional<Usuario> consultaUsuario = usuarioRepository.findById(usuarioId);
		if(consultaUsuario.isEmpty())
			return null;
		Double precio = solicitudPedidoDTO.getPrecio();
		
		Pedido pedido = new Pedido(usuarioId,precio);
		for (PedidoProductosDTO carrito : solicitudPedidoDTO.getProductos()) {
			Optional<Producto> consultaProducto = productosRepository.findById(carrito.getProductoid());
			if(consultaProducto.isPresent()) {
				Producto producto = consultaProducto.get();
				pedido.setProducto(producto);
			}
		}
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
