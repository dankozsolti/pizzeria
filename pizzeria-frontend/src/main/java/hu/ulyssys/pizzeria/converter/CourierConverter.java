package hu.ulyssys.pizzeria.converter;

import hu.ulyssys.pizzeria.entity.Courier;
import hu.ulyssys.pizzeria.service.CourierService;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ApplicationScoped
public class CourierConverter implements Converter {

    @Inject
    private CourierService courierService;

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        if (s == null) {
            return null;
        }
        String[] nameArray = s.split(" ",2);
        String firstName = nameArray[0];
        String lastName = nameArray[1];
        return courierService.findByFirstAndLastName(firstName,lastName);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if (o instanceof Courier) {
            return ((Courier) o).getFirstName() + " " + ((Courier) o).getLastName();
        }
        if (o instanceof String) {
            return o.toString();
        }
        return null;
    }
}

