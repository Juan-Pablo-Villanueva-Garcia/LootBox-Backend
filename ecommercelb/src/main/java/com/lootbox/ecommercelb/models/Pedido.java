package com.lootbox.ecommercelb.models;
//import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Pedido {
	
	private Long idPedido;//clase wrapper
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pedidoAt;
	//private Date pedido;
	private Long idUsuario;
	private Double precioTotal;
	private String status;//clase wrapper
	private static Long total = Long.valueOf(0);
	
	
	public Pedido(Date fecha, Long idUsuario, Double precioTotal, String status) {
		this.pedidoAt = fecha;
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

	public Date getPedidoAt() {
		return pedidoAt;
	}//getPedido

	public void setPedido(Date fecha) {
		this.pedidoAt = fecha;
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
		return "Pedidos [idPedido=" + idPedido + ", pedido=" + pedidoAt + ", idUsuario=" + idUsuario + ", precioTotal="
				+ precioTotal + ", status=" + status + "]";
	}//toString
	
}//class Pedidos
