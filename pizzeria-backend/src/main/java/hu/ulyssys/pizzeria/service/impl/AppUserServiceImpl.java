package hu.ulyssys.pizzeria.service.impl;

import hu.ulyssys.pizzeria.dao.AppUserDAO;
import hu.ulyssys.pizzeria.entity.AppUser;
import hu.ulyssys.pizzeria.service.AppUserService;

import javax.ejb.Stateless;

@Stateless
public class AppUserServiceImpl extends AbstractServiceImpl<AppUser> implements AppUserService {
    @Override
    public AppUser findByUsername(String username) {
        return ((AppUserDAO) dao).findByUsername(username);
    }
}
