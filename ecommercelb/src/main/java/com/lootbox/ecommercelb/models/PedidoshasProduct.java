package com.lootbox.ecommercelb.models;

import javax.persistence.*;

@Entity
@Table(name = "pedidos_has_product")
public class PedidoshasProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPedidoProd;

    private Long idPedido;

    private Long idUProducto;

    public PedidoshasProduct() {
    }

    public PedidoshasProduct(Long idPedido, Long idUProducto) {
        this.idPedido = idPedido;
        this.idUProducto = idUProducto;
    }

    // Getters y Setters
    public Long getIdPedidoProd() {
        return idPedidoProd;
    }

    public Long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Long idPedido) {
        this.idPedido = idPedido;
    }

    public Long getIdUProducto() {
        return idUProducto;
    }

    public void setIdUProducto(Long idUProducto) {
        this.idUProducto = idUProducto;
    }

    @Override
    public String toString() {
        return "PedidoshasProduct [idPedidoProd=" + idPedidoProd + ", idPedido=" + idPedido + ", idUProducto="
                + idUProducto + "]";
    }
}

