package com.lootbox.ecommercelb.dto;

public class PedidoProductosDTO {
    private Long productoid; // Este es el ID del producto existente
    private int cantidad;
    
    public PedidoProductosDTO() {}

	public PedidoProductosDTO(Long productoid, int cantidad) {
		this.productoid = productoid;
		this.cantidad = cantidad;
	}

	public Long getProductoid() {
		return productoid;
	}

	public int getCantidad() {
		return cantidad;
	}

	@Override
	public String toString() {
		return "PedidoProductosDTO [productoid=" + productoid + ", cantidad=" + cantidad + "]";
	}
}
