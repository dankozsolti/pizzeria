package hu.ulyssys.pizzeria.dao;

import hu.ulyssys.pizzeria.entity.AppUser;

public interface AppUserDAO extends CoreDAO<AppUser> {

    AppUser findByUsername(String username);

}
