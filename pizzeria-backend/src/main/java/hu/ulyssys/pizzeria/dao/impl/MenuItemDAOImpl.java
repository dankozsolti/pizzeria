package hu.ulyssys.pizzeria.dao.impl;

import hu.ulyssys.pizzeria.dao.MenuItemDAO;
import hu.ulyssys.pizzeria.entity.MenuItem;

import javax.ejb.Stateless;

@Stateless
public class MenuItemDAOImpl extends CoreDAOImpl<MenuItem> implements MenuItemDAO {



    @Override
    protected Class<MenuItem> getManagedClass() {
        return MenuItem.class;
    }
}
