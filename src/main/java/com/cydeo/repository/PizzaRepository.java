package com.cydeo.repository;

import com.cydeo.exception.PizzaNotFoundException;
import com.cydeo.model.Pizza;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class PizzaRepository {

    private static List<Pizza> pizzaList = new ArrayList<>();

    public Pizza createPizza(Pizza pizzaToSave) {
        pizzaList.add(pizzaToSave);
        return pizzaToSave;
    }

    public List<Pizza> readAll() {
        return pizzaList;
    }

    // TODO complete method
    public Pizza findPizzaById(UUID uuid) {
        return pizzaList.stream().filter(pizza -> pizza.getId().equals(uuid)).findFirst().orElseThrow(() -> new PizzaNotFoundException("Pizza not found"));
    }

}
