package hu.ulyssys.pizzeria.mbean;

import hu.ulyssys.pizzeria.entity.AppUser;
import hu.ulyssys.pizzeria.service.AppUserService;
import org.apache.commons.codec.digest.DigestUtils;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ViewScoped
public class AppUserCRUDMbean extends CoreCRUDMbean<AppUser> implements Serializable {


    @Inject
    public AppUserCRUDMbean(AppUserService userService, LoggedInUserBean loggedInUserBean) {
        super(userService);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság!");
        }
    }

    @Override
    protected String dialogName() {
        return "userDialog";
    }


    @Override
    public void save() {
        try {
            if (getSelectedEntity().getId() == null) {
                getSelectedEntity().setPasswordHash(hashPassword(getSelectedEntity().getPasswordHash()));
            }
            super.save();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Hiba történt hashelés közben!", ""));
            e.printStackTrace();
        }
    }

    @Override
    protected AppUser initNewEntity() {
        return new AppUser();
    }

    private String hashPassword(String rawPassword) {
        return DigestUtils.md5Hex(rawPassword);
    }

}
