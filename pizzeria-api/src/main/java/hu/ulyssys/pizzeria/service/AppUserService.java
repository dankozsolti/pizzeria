package hu.ulyssys.pizzeria.service;


import hu.ulyssys.pizzeria.entity.AppUser;

public interface AppUserService extends CoreService<AppUser> {

    AppUser findByUsername(String username);
}
