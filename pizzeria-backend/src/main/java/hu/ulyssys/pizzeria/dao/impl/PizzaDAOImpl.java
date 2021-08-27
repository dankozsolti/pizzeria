package hu.ulyssys.pizzeria.dao.impl;


import hu.ulyssys.pizzeria.dao.PizzaDAO;
import hu.ulyssys.pizzeria.entity.Pizza;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class PizzaDAOImpl extends CoreDAOImpl<Pizza> implements PizzaDAO {
    @Override
    protected Class<Pizza> getManagedClass() {
        return Pizza.class;
    }

    @Override
    public Pizza findByName(String name) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Pizza> criteriaQuery = criteriaBuilder.createQuery(Pizza.class);
        Root<Pizza> root = criteriaQuery.from(Pizza.class);
        criteriaQuery.select(root).where(criteriaBuilder.equal(root.get("name"), name));
        TypedQuery<Pizza> query = entityManager.createQuery(criteriaQuery);

        List<Pizza> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
