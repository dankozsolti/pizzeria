package hu.ulyssys.pizzeria.mbean;

import hu.ulyssys.pizzeria.entity.AbstractEntity;
import hu.ulyssys.pizzeria.entity.AbstractIdentity;
import hu.ulyssys.pizzeria.entity.AppUser;
import hu.ulyssys.pizzeria.service.AppUserService;
import hu.ulyssys.pizzeria.service.CoreService;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.Date;

public abstract class EntityCRUDMbean<T extends AbstractEntity> extends CoreCRUDMbean<T> implements Serializable {

    @Inject
    private AppUserService appUserService;

    @Inject
    private LoggedInUserBean loggedInUserBean;

    @Inject
    public EntityCRUDMbean(CoreService<T> service) {
        super(service);
    }

    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setCreatedDate(ZonedDateTime.now());
                getSelectedEntity().setModifiedDate(ZonedDateTime.now());
                getSelectedEntity().setCreatorUser(appUserService.findByUsername(loggedInUserBean.getModel().getUsername()));
                getSelectedEntity().setModifierUser(appUserService.findByUsername(loggedInUserBean.getModel().getUsername()));
            } else {
                getSelectedEntity().setModifiedDate(ZonedDateTime.now());
                getSelectedEntity().setModifierUser(appUserService.findByUsername(loggedInUserBean.getModel().getUsername()));
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen mentés", null));
            e.printStackTrace();

        }
    }

}
