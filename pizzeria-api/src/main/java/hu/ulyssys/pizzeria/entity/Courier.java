package hu.ulyssys.pizzeria.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table
@Entity
public class Courier extends AbstractEntity {

    @Column(name = "first_name",nullable = false, length = 500)
    private String firstName;
    @Column(name = "last_name",nullable = false, length = 500)
    private String lastName;
    @Column(name = "phone_number",nullable = false)
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Courier courier = (Courier) o;
        return Objects.equals(firstName, courier.firstName) &&
            Objects.equals(lastName, courier.lastName) &&
            Objects.equals(phoneNumber, courier.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phoneNumber);
    }
}
