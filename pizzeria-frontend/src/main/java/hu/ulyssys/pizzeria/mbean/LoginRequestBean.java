package hu.ulyssys.pizzeria.mbean;

import hu.ulyssys.pizzeria.entity.AppUser;
import hu.ulyssys.pizzeria.mbean.model.LoggedInUserModel;
import hu.ulyssys.pizzeria.mbean.model.LoginModel;
import hu.ulyssys.pizzeria.service.AppUserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.primefaces.PrimeFaces;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginRequestBean {
    private LoginModel model = new LoginModel();

    @Inject
    private LoggedInUserBean bean;

    @Inject
    private AppUserService userService;

    public void doLogin() {

        try {
            AppUser user = userService.findByUsername(model.getUsername());
            if (user == null) {
                throw new SecurityException("Nem létező felhasználó!");
            }
            String hashedPassword = DigestUtils.md5Hex(model.getPassword());

            if (!hashedPassword.equals(user.getPasswordHash())) {
                throw new SecurityException("Nem megfelelő jelszó!");

            }

            LoggedInUserModel loggedInUserModel = new LoggedInUserModel();
            loggedInUserModel.setUsername(user.getUsername());
            loggedInUserModel.setId(user.getId());
            loggedInUserModel.setRole(user.getRole());
            bean.setModel(loggedInUserModel);
            PrimeFaces.current().executeScript("PF('loginDialog').hide()");

        } catch (Exception e) {
            e.printStackTrace();
            FacesContext.getCurrentInstance()
                .addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sikertelen bejelentkezés!", ""));
        }


    }

    public void doLogout() {
        bean.setModel(null);
    }

    public LoginModel getModel() {
        return model;
    }

    public void setModel(LoginModel model) {
        this.model = model;
    }
}
