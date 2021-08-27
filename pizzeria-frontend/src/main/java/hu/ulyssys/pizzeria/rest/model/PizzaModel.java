package hu.ulyssys.pizzeria.rest.model;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PizzaModel extends CoreRestModel {

    @NotEmpty
    @Size(max = 200)
    private String name;
    @NotEmpty
    @Size(max = 500)
    private String description;
    @NotNull
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
}
