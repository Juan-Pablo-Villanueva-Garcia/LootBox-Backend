package com.lootbox.ecommercelb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lootbox.ecommercelb.models.PedidoshasProduct;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoshasProductRepository extends JpaRepository<PedidoshasProduct, Long> {
    
    // BUSCAR ID
    List<PedidoshasProduct> findByIdPedido(Long idPedido);
}
