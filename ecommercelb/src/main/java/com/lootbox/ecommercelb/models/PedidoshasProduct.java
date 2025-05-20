package com.lootbox.ecommercelb.models;



public class PedidoshasProduct {
	private Long idPedidoProd;
	private Long idPedido;//clase wrapper
	private Long idUProducto;
	private static Long total = Long.valueOf(0);
	
	public PedidoshasProduct(Long idPedidoProd,Long idPedido, Long idUProducto) {
		this.idPedidoProd = idPedidoProd;
		this.idPedido = idPedido;
		this.idUProducto = idUProducto;
		
		PedidoshasProduct.total++;
		this.idPedidoProd = PedidoshasProduct.total;
	}//constructor con campos
	
	//Getters and Setters
	public PedidoshasProduct() {
		PedidoshasProduct.total++;
		this.idPedidoProd = PedidoshasProduct.total;
	}//constructor vacío 

	public Long getIdPedidoProd() {
		return idPedidoProd;
	}//getIdPedidoProd

	public Long getIdPedido() {
		return idPedido;
	}//getIdPedido

	public Long getIdUProducto() {
		return idUProducto;
	}//getIdPedido

	//toString
	@Override
	public String toString() {
		return "PedidoshasProduct [idPedidoProd=" + idPedidoProd + ", idPedido=" + idPedido + ", idUProducto="
				+ idUProducto + "]";
	}//toString
	
	
	
	
}//class PedidohasProduct
