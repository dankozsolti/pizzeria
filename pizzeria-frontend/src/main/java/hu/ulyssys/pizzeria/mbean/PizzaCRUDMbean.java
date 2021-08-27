package hu.ulyssys.pizzeria.mbean;

import hu.ulyssys.pizzeria.entity.Pizza;
import hu.ulyssys.pizzeria.service.PizzaService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class PizzaCRUDMbean extends EntityCRUDMbean<Pizza> implements Serializable {

    @Inject
    public PizzaCRUDMbean(PizzaService pizzaService) {
        super(pizzaService);
    }

    @Override
    protected String dialogName() {
        return "pizzaDialog";
    }

    @Override
    protected Pizza initNewEntity() {
        return new Pizza();
    }
}
