package hu.ulyssys.pizzeria.service;

import hu.ulyssys.pizzeria.entity.Pizza;

import java.util.List;

public interface PizzaService extends CoreService<Pizza>{

    Pizza findByName(String name);

    List<Pizza> getSelectedPizzasFromStrings(List<String> pizzaStrings);
}
