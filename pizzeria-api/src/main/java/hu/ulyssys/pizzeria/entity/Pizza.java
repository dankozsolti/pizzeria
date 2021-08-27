package hu.ulyssys.pizzeria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;

@Table
@Entity
public class Pizza extends AbstractEntity {

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, length = 500)
    private String description;

    @Column(nullable = false)
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pizza pizza = (Pizza) o;
        return Objects.equals(name, pizza.name) && Objects.equals(description, pizza.description) &&
            Objects.equals(price, pizza.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price);
    }
}
