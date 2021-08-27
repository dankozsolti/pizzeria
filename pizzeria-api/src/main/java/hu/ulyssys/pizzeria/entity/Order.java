package hu.ulyssys.pizzeria.entity;

import javax.faces.annotation.ManagedProperty;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Table(name = "pizza_order")
@Entity
public class Order extends AbstractEntity {

    @Column(name = "delivery_date", nullable = false)
    private Date deliveryDate;

    @Column(nullable = false, length = 200)
    private String city;

    @Column(nullable = false, length = 200)
    private String street;

    @Column(name = "street_type", nullable = false, length = 200)
    private String streetType;

    @Column(name = "house_number", nullable = false, length = 200)
    private String houseNumber;

    @JoinColumn(name = "courier_id")
    @ManyToOne
    private Courier courier;

    @OneToMany(targetEntity = Pizza.class, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<Pizza> pizzaList;

    public List<Pizza> getPizzaList() {
        return pizzaList;
    }

    public void setPizzaList(List<Pizza> pizzaList) {
        this.pizzaList = pizzaList;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Order order = (Order) o;
        return Objects.equals(deliveryDate, order.deliveryDate) && Objects.equals(city, order.city) &&
            Objects.equals(street, order.street) && Objects.equals(streetType, order.streetType) &&
            Objects.equals(houseNumber, order.houseNumber) && Objects.equals(courier, order.courier) &&
            Objects.equals(pizzaList, order.pizzaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deliveryDate, city, street, streetType, houseNumber, courier, pizzaList);
    }
}
