package hu.ulyssys.pizzeria.service.impl;

import hu.ulyssys.pizzeria.dao.PizzaDAO;
import hu.ulyssys.pizzeria.entity.Pizza;
import hu.ulyssys.pizzeria.service.PizzaService;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PizzaServiceImpl extends AbstractServiceImpl<Pizza> implements PizzaService {

    @Override
    public Pizza findByName(String name) {
        return ((PizzaDAO) dao).findByName(name);
    }

    @Override
    public List<Pizza> getSelectedPizzasFromStrings(List<String> pizzaStrings) {
        List<Pizza> pizzas = new ArrayList<>();
        for (String pizzaString : pizzaStrings) {
            pizzas.add(findByName(pizzaString));
        }
        return pizzas;
    }

}
