package hu.ulyssys.pizzeria.rest;

import hu.ulyssys.pizzeria.entity.Order;
import hu.ulyssys.pizzeria.rest.model.OrderModel;

import javax.ws.rs.Path;

@Path("/order")
public class OrderRestService extends CoreRestService<Order, OrderModel> {


    @Override
    protected Order initNewEntity() {
        return new Order();
    }
}
