package hu.ulyssys.pizzeria.dao;

import hu.ulyssys.pizzeria.entity.Courier;

public interface CourierDAO extends CoreDAO<Courier>{

    Courier findByFirstAndLastName(String firstName, String lastName);
}
