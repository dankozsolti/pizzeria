package hu.ulyssys.pizzeria.mbean;

import hu.ulyssys.pizzeria.entity.Courier;
import hu.ulyssys.pizzeria.entity.Order;
import hu.ulyssys.pizzeria.entity.Pizza;
import hu.ulyssys.pizzeria.service.CourierService;
import hu.ulyssys.pizzeria.service.OrderService;
import hu.ulyssys.pizzeria.service.PizzaService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class OrderCRUDMbean extends EntityCRUDMbean<Order> implements Serializable {

    private List<Courier> courierList;

    private List<Pizza> pizzaList;

    private List<String> selectedPizzaStrings;

    private List<Pizza> selectedPizzas;

    @Inject
    private PizzaService pizzaService;

    @Inject
    private CourierService courierService;

    @Inject
    public OrderCRUDMbean(OrderService orderService) {
        super(orderService);
    }

    @PostConstruct
    void init() {
        this.courierList = courierService.getAll();
        this.pizzaList = pizzaService.getAll();
    }

    @Override
    public void save() {
        try {
            getSelectedEntity().setPizzaList(pizzaService.getSelectedPizzasFromStrings(selectedPizzaStrings));

            if (getSelectedEntity().getDeliveryDate().compareTo(new Date()) < 0) {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "A kiszállítási idő nem lehet a múltban!", null));
            } else if (getSelectedEntity().getPizzaList().isEmpty()) {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Legalább egy pizzát ki kell választani!", null));
            } else if(getSelectedEntity().getCourier().getId().equals(null)) {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Futárt ki kell választani!", null));
            } else {
                super.save();
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen mentés!", null));

        }
    }


    @Override
    protected String dialogName() {
        return "orderDialog";
    }

    @Override
    protected Order initNewEntity() {
        return new Order();
    }

    public List<Pizza> getSelectedPizzas() {
        return selectedPizzas;
    }

    public List<String> getSelectedPizzaStrings() {
        return selectedPizzaStrings;
    }

    public void setSelectedPizzaStrings(List<String> selectedPizzaStrings) {
        this.selectedPizzaStrings = selectedPizzaStrings;
    }

    public void setSelectedPizzas(List<Pizza> selectedPizzas) {
        this.selectedPizzas = selectedPizzas;
    }

    public List<Courier> getCourierList() {
        return courierList;
    }

    public void setCourierList(List<Courier> courierList) {
        this.courierList = courierList;
    }

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }
}
