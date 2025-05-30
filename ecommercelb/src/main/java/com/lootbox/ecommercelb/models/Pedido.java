package com.lootbox.ecommercelb.models;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.Base64;
//import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pedidos")
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String numeroPedido;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fechaPedido;
	private Double precioTotal;
	private String status;
	private Long usuarioid;//Referencia a cual usuario pertenece
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
        name = "pedido_producto", // Nombre de la tabla intermedia
        joinColumns = @JoinColumn(name = "pedido_fk"), // Columna para la clave foránea de Order
        inverseJoinColumns = @JoinColumn(name = "producto_fk") // Columna para la clave foránea de Product
    )
    private Set<Producto> productos = new HashSet<>();
	
	
	public Pedido() {
		this.fechaPedido = LocalDateTime.now();
		this.status = "Generando pedido";
		this.numeroPedido = generateRandomString();
	}//Constructor "vacio"
	
	public Pedido(Long usuarioid,Double precioTotal) {
		this();
		this.usuarioid = usuarioid;
		this.precioTotal = precioTotal;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public String getNumeroPedido() {
		return numeroPedido;
	}

	public LocalDateTime getFechaPedido() {
		return fechaPedido;
	}

	public Double getPrecioTotal() {
		return precioTotal;
	}

	public Set<Producto> getProductos() {
		return productos;
	}

	public Long getUsuarioid() {
		return usuarioid;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", numeroPedido=" + numeroPedido + ", fechaPedido=" + fechaPedido + ", precioTotal="
				+ precioTotal + ", status=" + status + ", usuarioid=" + usuarioid + ", productos=" + productos + "]";
	}

	//String aleatorio del numero de pedido
	public static String generateRandomString() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] randomBytes = new byte[10];
        secureRandom.nextBytes(randomBytes);
        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }
	

	
}//class Pedidos
