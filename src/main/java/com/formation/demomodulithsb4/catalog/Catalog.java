package com.formation.demomodulithsb4.catalog;

import com.formation.demomodulithsb4.catalog.internal.CoffeeEntity;
import com.formation.demomodulithsb4.catalog.internal.CoffeeRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class Catalog {

    private final CoffeeRepository repository;
    private final ApplicationEventPublisher events;

    public Catalog(CoffeeRepository repository, ApplicationEventPublisher events) {
        this.repository = repository;
        this.events = events;
    }

    @Transactional
    public Long createCoffee(String name, int price) {
        CoffeeEntity saved = repository.save(new CoffeeEntity(name, price));
        events.publishEvent(new CoffeeCreated(saved.getId(), saved.getName()));
        return saved.getId();
    }
}