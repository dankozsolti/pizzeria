package hu.ulyssys.pizzeria.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Table
@Entity
public class MenuItem extends AbstractIdentity {

    private String url;
    private String label;
    private Boolean adminFunction;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Boolean getAdminFunction() {
        return adminFunction;
    }

    public void setAdminFunction(Boolean adminFunction) {
        this.adminFunction = adminFunction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MenuItem menuItem = (MenuItem) o;
        return Objects.equals(url, menuItem.url) && Objects.equals(label, menuItem.label) &&
            Objects.equals(adminFunction, menuItem.adminFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, label, adminFunction);
    }
}
