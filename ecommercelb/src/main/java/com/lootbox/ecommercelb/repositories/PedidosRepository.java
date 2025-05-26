package com.lootbox.ecommercelb.repositories;


import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lootbox.ecommercelb.models.Pedido;
import com.lootbox.ecommercelb.models.Usuario;


@Repository
public interface PedidosRepository extends JpaRepository<Pedido, Long>{
	Optional<Pedido> findByPedidoAt(Date pedidoAt);
	Optional<Pedido> findByUsuario(Usuario usuario);

}
