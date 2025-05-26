package com.lootbox.ecommercelb.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class OrdenId implements Serializable{
	private static final long serialVersionUID = 1L; // Importante para Serializable

    private Long productoId;
    private Long pedidoId;

    // Constructores
    public OrdenId() {}

    public OrdenId(Long productoId, Long pedidoId) {
        this.productoId = productoId;
        this.pedidoId = pedidoId;
    }

    // Getters y Setters 
    public Long getProductoId() {
  		return productoId;
  	}

  	public void setProductoId(Long productoId) {
  		this.productoId = productoId;
  	}

  	public Long getPedidoId() {
  		return pedidoId;
  	}

  	public void setPedidoId(Long pedidoId) {
  		this.pedidoId = pedidoId;
  	}
    

    // Es fundamental implementar equals() y hashCode() para claves compuestas
    @Override
    public boolean equals(Object objeto) {
        if (this == objeto) return true;
        if (objeto == null || getClass() != objeto.getClass()) return false;
        OrdenId that = (OrdenId) objeto;
        return Objects.equals(productoId, that.productoId) &&
               Objects.equals(pedidoId, that.pedidoId);
    }

	@Override
	public String toString() {
		return "OrdenId [productoId=" + productoId + ", pedidoId=" + pedidoId + "]";
	}

	@Override
    public int hashCode() {
        return Objects.hash(productoId, pedidoId);
    }
	

}
