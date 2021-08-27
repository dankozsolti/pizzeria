package hu.ulyssys.pizzeria.rest;

import hu.ulyssys.pizzeria.entity.Pizza;
import hu.ulyssys.pizzeria.rest.model.PizzaModel;

import javax.ws.rs.Path;

@Path("/pizza")
public class PizzaRestService extends CoreRestService<Pizza, PizzaModel> {


    @Override
    protected Pizza initNewEntity() {
        return new Pizza();
    }
}
