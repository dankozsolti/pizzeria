package hu.ulyssys.pizzeria.rest;

import hu.ulyssys.pizzeria.entity.Courier;
import hu.ulyssys.pizzeria.entity.Pizza;
import hu.ulyssys.pizzeria.rest.model.CourierModel;
import hu.ulyssys.pizzeria.rest.model.PizzaModel;

import javax.ws.rs.Path;

@Path("/courier")
public class CourierRestService extends CoreRestService<Courier, CourierModel> {


    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
