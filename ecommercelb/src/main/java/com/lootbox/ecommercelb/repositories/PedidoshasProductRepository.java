package com.lootbox.ecommercelb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lootbox.ecommercelb.models.Pedido;
import com.lootbox.ecommercelb.models.PedidoshasProduct;
import com.lootbox.ecommercelb.models.Producto;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoshasProductRepository extends JpaRepository<PedidoshasProduct, Long> {
    
    // BUSCAR ID
    List<PedidoshasProduct> findByPedido(Pedido pedido);
    List<PedidoshasProduct> findByProducto(Producto producto);
}
