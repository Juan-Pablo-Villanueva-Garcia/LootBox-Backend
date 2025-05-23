package com.lootbox.ecommercelb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lootbox.ecommercelb.models.Pedido;


@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long>{

}
