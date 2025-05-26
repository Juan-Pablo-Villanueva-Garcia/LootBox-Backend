package com.lootbox.ecommercelb.models;
//import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;//clase wrapper
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pedidoAt;
	private Double precioTotal;
	private String status;//clase wrapper
	@ManyToOne
	@JoinColumn(name = "usuario_fk")
	private Usuario usuario; // Atributo al que se refiere el mappedBy
	
	@OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<PedidoshasProduct> pedidos_has_product = new HashSet<>();
	
	
	
	public Pedido(Date fecha, Double precioTotal, String status, Usuario usuario) {
		this.pedidoAt = fecha;
		this.usuario = usuario;
		this.precioTotal = precioTotal;
		this.status = status;
	} //Constructor con campos
	
	public Pedido () {} //Constructor vacío
	
	//Getters and Setters
	public Long getId() {
		return id;
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

	public Usuario getUsuario() {
		return this.usuario;
	}//getIdUsuario

	@Override
	public String toString() {
		return "Pedidos [id=" + id + ", pedido=" + pedidoAt + ", Usuario=" + usuario + ", precioTotal="
				+ precioTotal + ", status=" + status + "]";
	}//toString
	
}//class Pedidos
