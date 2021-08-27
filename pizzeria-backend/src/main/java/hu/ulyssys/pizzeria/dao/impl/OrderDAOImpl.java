package hu.ulyssys.pizzeria.dao.impl;

import hu.ulyssys.pizzeria.dao.OrderDAO;
import hu.ulyssys.pizzeria.entity.Order;

import javax.ejb.Stateless;

@Stateless
public class OrderDAOImpl extends CoreDAOImpl<Order> implements OrderDAO {
    @Override
    protected Class<Order> getManagedClass() {
        return Order.class;
    }
}
