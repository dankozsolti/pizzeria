package hu.ulyssys.pizzeria.mbean;

import hu.ulyssys.pizzeria.entity.Courier;
import hu.ulyssys.pizzeria.service.CourierService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class CourierCRUDMbean extends EntityCRUDMbean<Courier> implements Serializable {

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getFirstName().equals(getSelectedEntity().getLastName()))
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "A keresztnév és vezetéknév nem lehet azonos!", null));
            else {
                super.save();
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen mentés", null));

        }
    }

    @Inject
    public CourierCRUDMbean(CourierService courierService) {
        super(courierService);
    }

    @Override
    protected String dialogName() {
        return "courierDialog";
    }

    @Override
    protected Courier initNewEntity() {
        return new Courier();
    }
}
