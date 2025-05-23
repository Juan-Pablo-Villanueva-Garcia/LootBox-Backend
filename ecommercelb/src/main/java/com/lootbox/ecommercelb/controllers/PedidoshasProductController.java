package com.lootbox.ecommercelb.controllers;

import com.lootbox.ecommercelb.models.PedidoshasProduct;
import com.lootbox.ecommercelb.services.PedidoshasProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidoprod/")
public class PedidoshasProductController {

    @Autowired
    private PedidoshasProductService service;

    @GetMapping
    public List<PedidoshasProduct> getAll() {
        return service.getAll();
    }

    @GetMapping("{idPedido}")
    public List<PedidoshasProduct> getByPedidoId(@PathVariable Long idPedido) {
        return service.getByPedidoId(idPedido);
    }

    @PostMapping
    public PedidoshasProduct create(@RequestBody PedidoshasProduct nuevo) {
        return service.create(nuevo);
    }

    @PutMapping("{idPedidoProd}")
    public PedidoshasProduct update(@PathVariable Long idPedidoProd, @RequestBody PedidoshasProduct updated) {
        return service.update(idPedidoProd, updated);
    }

    @DeleteMapping("{idPedidoProd}")
    public String delete(@PathVariable Long idPedidoProd) {
        boolean removed = service.delete(idPedidoProd);
        return removed ? "eliminado" : "No encontrado";
    }
}
