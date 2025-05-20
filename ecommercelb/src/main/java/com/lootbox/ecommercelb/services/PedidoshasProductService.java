package com.lootbox.ecommercelb.services;

import com.lootbox.ecommercelb.models.PedidoshasProduct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoshasProductService {
    private final List<PedidoshasProduct> lista = new ArrayList<>();

    // Constructor para precargar datos
    public PedidoshasProductService() {
        lista.add(new PedidoshasProduct(null,1L, 100L));
        lista.add(new PedidoshasProduct(null,1L, 101L));
        lista.add(new PedidoshasProduct(null,2L, 200L));
    }

    public List<PedidoshasProduct> getAll() {
        return lista;
    }

    public List<PedidoshasProduct> getByPedidoId(Long idPedido) {
        return lista.stream()
                .filter(p -> p.getIdPedido().equals(idPedido))
                .collect(Collectors.toList());
    }

    public PedidoshasProduct create(PedidoshasProduct nuevo) {
        lista.add(nuevo);
        return nuevo;
    }

    public boolean delete(Long idPedidoProd) {
        return lista.removeIf(p -> p.getIdPedidoProd().equals(idPedidoProd));
        }
}