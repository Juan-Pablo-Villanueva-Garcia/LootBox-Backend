package com.lootbox.ecommercelb.models;

import java.util.Date;

public class Pedido {
	private Long idPedido;//clase wrapper
	private Date pedido;
	private Long idUsuario;
	private Double precioTotal;
	private String status;//clase wrapper
	private static Long total = Long.valueOf(0);
	
	public Pedido(Date pedido, Long idUsuario, Double precioTotal, String status) {
		
		this.pedido = pedido;
		this.idUsuario = idUsuario;
		this.precioTotal = precioTotal;
		this.status = status;
		Pedido.total++;
		this.idPedido = Pedido.total;	
	} //Constructor con campos
	
	public Pedido () {
		Pedido.total++;
		this.idPedido = Pedido.total;
	} //Constructor vacío
	
	//Getters and Setters
	public Long getIdPedido() {
		return idPedido;
	}//getIdPedido

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}//setIdPedido

	public Date getPedido() {
		return pedido;
	}//getPedido

	public void setPedido(Date pedido) {
		this.pedido = pedido;
	}//setPedido

	public Double getPrecioTotal() {
		return precioTotal;
	}//getPrecioTotal

	public void setPrecioTotal(Double precioTotal) {
		this.precioTotal = precioTotal;
	}//setPrecioTotal

	public String getStatus() {
		return status;
	}//getStatus

	public void setStatus(String status) {
		this.status = status;
	}//setStatus

	public Long getIdUsuario() {
		return idUsuario;
	}//getIdUsuario

	@Override
	public String toString() {
		return "Pedidos [idPedido=" + idPedido + ", pedido=" + pedido + ", idUsuario=" + idUsuario + ", precioTotal="
				+ precioTotal + ", status=" + status + "]";
	}//toString
	
}//class Pedidos
