package hu.ulyssys.pizzeria.rest.model;

import hu.ulyssys.pizzeria.entity.Courier;
import hu.ulyssys.pizzeria.entity.Pizza;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

public class OrderModel extends CoreRestModel {

    @NotNull
    @Future
    private Date deliveryDate;
    @NotEmpty
    @Size(max = 200)
    private String city;
    @NotEmpty
    @Size(max = 200)
    private String street;
    @NotEmpty
    @Size(max = 200)
    private String streetType;
    @NotEmpty
    @Size(max = 200)
    private String houseNumber;

    @NotNull
    private Courier courier;

    @NotEmpty
    private List<Pizza> pizzas;

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetType() {
        return streetType;
    }

    public void setStreetType(String streetType) {
        this.streetType = streetType;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
