package com.lootbox.ecommercelb.services;

import com.lootbox.ecommercelb.models.PedidoshasProduct;
import com.lootbox.ecommercelb.repositories.PedidoshasProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoshasProductService {

    @Autowired
    private PedidoshasProductRepository repository;

    // Obtener todos los registros
    public List<PedidoshasProduct> getAll() {
        return repository.findAll();
    }

    // Obtener registros con idPedido
    public List<PedidoshasProduct> getByPedidoId(Long idPedido) {
        return repository.findByIdPedido(idPedido);
    }

    // Nuevo registro
    public PedidoshasProduct create(PedidoshasProduct nuevo) {
        return repository.save(nuevo);
    }

    // Actualizar registro existente
    public PedidoshasProduct update(Long idPedidoProd, PedidoshasProduct updated) {
        Optional<PedidoshasProduct> optional = repository.findById(idPedidoProd);
        if (optional.isPresent()) {
            PedidoshasProduct existente = optional.get();
            existente.setIdPedido(updated.getIdPedido());
            existente.setIdUProducto(updated.getIdUProducto());
            return repository.save(existente);
        } else {
            return null; 
        }
    }

    // Eliminar registro por idPedidoProd
    public boolean delete(Long idPedidoProd) {
        if (repository.existsById(idPedidoProd)) {
            repository.deleteById(idPedidoProd);
            return true;
        }
        return false;
    }
}
