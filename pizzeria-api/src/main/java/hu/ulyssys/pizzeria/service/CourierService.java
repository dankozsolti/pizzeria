package hu.ulyssys.pizzeria.service;

import hu.ulyssys.pizzeria.entity.Courier;

public interface CourierService extends CoreService<Courier>{

    Courier findByFirstAndLastName(String firstName, String lastName);

}
