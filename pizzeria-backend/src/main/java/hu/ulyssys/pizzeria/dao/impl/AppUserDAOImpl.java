package hu.ulyssys.pizzeria.dao.impl;

import hu.ulyssys.pizzeria.dao.AppUserDAO;
import hu.ulyssys.pizzeria.entity.AppUser;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class AppUserDAOImpl extends CoreDAOImpl<AppUser> implements AppUserDAO {

    @Override
    public AppUser findByUsername(String username) {
        TypedQuery<AppUser> query = entityManager.createNamedQuery(AppUser.FIND_BY_USERNAME, AppUser.class);
        query.setParameter("username", username);
        List<AppUser> appUserList = query.getResultList();
        if (appUserList.isEmpty()) {
            return null;
        }
        return appUserList.get(0);
    }

    @Override
    protected Class<AppUser> getManagedClass() {
        return AppUser.class;
    }
}
