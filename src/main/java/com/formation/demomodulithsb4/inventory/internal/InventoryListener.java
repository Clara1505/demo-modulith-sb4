package com.formation.demomodulithsb4.inventory.internal;

import com.formation.demomodulithsb4.catalog.CoffeeCreated;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

@Component
class InventoryListener {

    private final StockRepository repository;

    InventoryListener(StockRepository repository) {
        this.repository = repository;
    }

    @ApplicationModuleListener
    void on(CoffeeCreated event) {
        repository.save(new StockEntity(event.coffeeId(), 0));
    }
}