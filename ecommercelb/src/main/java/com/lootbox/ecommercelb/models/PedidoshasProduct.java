package com.lootbox.ecommercelb.models;

import javax.persistence.*;

@Entity
@Table(name = "pedidos_has_product")
public class PedidoshasProduct {

    @EmbeddedId
    private OrdenId id;
    
    @ManyToOne
    @MapsId("pedidoId")
    @JoinColumn(name = "pedido_fk")
    private Pedido pedido;
    
    
    @ManyToOne
    @MapsId("productoId")
    @JoinColumn(name = "producto_fk")
    private Producto producto;

    public PedidoshasProduct() {
    }

    public PedidoshasProduct(Pedido pedido, Producto producto) {
        this.pedido = pedido;
        this.producto = producto;
        this.id = new OrdenId(pedido.getId(),producto.getId());
    }

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public OrdenId getIdPedido() {
		return id;
	}

	@Override
	public String toString() {
		return "PedidoshasProduct [id=" + id + ", pedido=" + pedido + ", producto=" + producto + "]";
	}



    
}

