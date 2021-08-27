package hu.ulyssys.pizzeria.dao;

import hu.ulyssys.pizzeria.entity.Pizza;

public interface PizzaDAO extends CoreDAO<Pizza>{

    Pizza findByName(String name);
}
