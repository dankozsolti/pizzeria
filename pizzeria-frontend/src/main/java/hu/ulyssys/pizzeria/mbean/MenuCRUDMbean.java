package hu.ulyssys.pizzeria.mbean;

import hu.ulyssys.pizzeria.entity.MenuItem;
import hu.ulyssys.pizzeria.service.MenuItemService;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;


@Named
@ViewScoped
public class MenuCRUDMbean extends CoreCRUDMbean<MenuItem> implements Serializable {
    @Inject
    public MenuCRUDMbean(MenuItemService menuItemService, LoggedInUserBean loggedInUserBean) {
        super(menuItemService);
        if (!loggedInUserBean.isAdmin()) {
            throw new SecurityException("Nincs elég jogosultság!");
        }

        for (MenuItem item : menuItemService.getAll()) {
            MenuItem menuItem = new MenuItem();
            menuItem.setLabel(item.getLabel());
            menuItem.setUrl(item.getUrl());
            menuItem.setAdminFunction(item.getAdminFunction());
        }
    }

    @Override
    protected String dialogName() {
        return "menuDialog";
    }

    @Override
    protected MenuItem initNewEntity() {
        return new MenuItem();
    }
}
