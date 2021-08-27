package hu.ulyssys.pizzeria.rest.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CourierModel extends CoreRestModel {

    @NotEmpty
    @Size(max = 500)
    private String firstName;
    @NotEmpty
    @Size(max = 500)
    private String lastName;
    @NotEmpty
    @Pattern(regexp="^(\\+36|06)[- ]?(1|\\d{2})[- ]?(\\d{3})[- ]?(\\d{4})$")
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
