package com.lootbox.ecommercelb.dto;

import java.util.List;

public class SolicitudPedidoDTO {
	private Long usuarioid;
	private List<PedidoProductosDTO> productos;
	private Double precio;
	
	public SolicitudPedidoDTO() {
	}

	public SolicitudPedidoDTO(Long usuarioid, List<PedidoProductosDTO> productos, Double precio) {
		this.usuarioid = usuarioid;
		this.productos = productos;
		this.precio = precio;
	}

	public Long getUsuarioid() {
		return usuarioid;
	}

	public List<PedidoProductosDTO> getProductos() {
		return productos;
	}
	
	public Double getPrecio() {
		return precio;
	}

	@Override
	public String toString() {
		return "SolicitudPedidoDTO [usuarioid=" + usuarioid + ", productos=" + productos + ", precio=" + precio + "]";
	}

}
