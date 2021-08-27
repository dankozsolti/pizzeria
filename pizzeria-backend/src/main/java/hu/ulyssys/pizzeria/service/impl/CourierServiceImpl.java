package hu.ulyssys.pizzeria.service.impl;

import hu.ulyssys.pizzeria.dao.CourierDAO;
import hu.ulyssys.pizzeria.entity.Courier;
import hu.ulyssys.pizzeria.service.CourierService;

import javax.ejb.Stateless;

@Stateless
public class CourierServiceImpl extends AbstractServiceImpl<Courier> implements CourierService {


    @Override
    public Courier findByFirstAndLastName(String firstName, String lastName) {
        return ((CourierDAO) dao).findByFirstAndLastName(firstName,lastName);
    }
}
