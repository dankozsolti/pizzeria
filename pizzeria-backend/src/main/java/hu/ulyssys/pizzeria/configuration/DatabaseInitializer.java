package hu.ulyssys.pizzeria.configuration;

import hu.ulyssys.pizzeria.entity.AppUser;
import hu.ulyssys.pizzeria.entity.AppUserRole;
import hu.ulyssys.pizzeria.entity.MenuItem;
import hu.ulyssys.pizzeria.service.AppUserService;
import hu.ulyssys.pizzeria.service.MenuItemService;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;

@Named
@Startup
@Singleton
public class DatabaseInitializer {
    @Inject
    private MenuItemService menuItemService;

    @Inject
    private AppUserService appUserService;

    public DatabaseInitializer() {
    }

    @PostConstruct
    void init() {
        if (appUserService.getAll().isEmpty()) {
            AppUser admin = new AppUser();
            admin.setUsername("admin");
            admin.setPasswordHash("21232f297a57a5a743894a0e4a801fc3");
            admin.setCreatedDate(new Date(System.currentTimeMillis()));
            admin.setRole(AppUserRole.ADMIN);
            appUserService.add(admin);

            AppUser testUser = new AppUser();
            testUser.setUsername("test");
            testUser.setPasswordHash("098f6bcd4621d373cade4e832627b4f6");
            testUser.setCreatedDate(new Date(System.currentTimeMillis()));
            testUser.setRole(AppUserRole.USER);
            appUserService.add(testUser);
        }

        if (menuItemService.getAll().isEmpty()) {
            MenuItem orderMenu = new MenuItem();
            orderMenu.setLabel("Rendelés");
            orderMenu.setUrl("/xhtml/order.xhtml");
            orderMenu.setAdminFunction(false);
            menuItemService.add(orderMenu);

            MenuItem pizzaMenu = new MenuItem();
            pizzaMenu.setLabel("Pizza");
            pizzaMenu.setUrl("/xhtml/pizza.xhtml");
            pizzaMenu.setAdminFunction(false);
            menuItemService.add(pizzaMenu);

            MenuItem courierMenu = new MenuItem();
            courierMenu.setLabel("Futár");
            courierMenu.setUrl("/xhtml/courier.xhtml");
            courierMenu.setAdminFunction(true);
            menuItemService.add(courierMenu);

            MenuItem appUserMenu = new MenuItem();
            appUserMenu.setLabel("Felhasználó");
            appUserMenu.setUrl("/xhtml/appUser.xhtml");
            appUserMenu.setAdminFunction(true);
            menuItemService.add(appUserMenu);

            MenuItem menuMenu = new MenuItem();
            menuMenu.setLabel("MenuItem");
            menuMenu.setUrl("/xhtml/menuItem.xhtml");
            menuMenu.setAdminFunction(true);
            menuItemService.add(menuMenu);
        }
    }
}
