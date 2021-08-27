package hu.ulyssys.pizzeria.dao.impl;

import hu.ulyssys.pizzeria.dao.CourierDAO;
import hu.ulyssys.pizzeria.entity.Courier;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class CourierDAOImpl extends CoreDAOImpl<Courier> implements CourierDAO {
    @Override
    protected Class<Courier> getManagedClass() {
        return Courier.class;
    }

    @Override
    public Courier findByFirstAndLastName(String firstName, String lastName) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Courier> criteriaQuery = criteriaBuilder.createQuery(Courier.class);
        Root<Courier> root = criteriaQuery.from(Courier.class);

        Predicate firstNamePredicate = criteriaBuilder.equal(root.get("firstName"),firstName);
        Predicate lastNamePredicate = criteriaBuilder.equal(root.get("lastName"),lastName);
        Predicate finalPredicate = criteriaBuilder.and(firstNamePredicate,lastNamePredicate);
        criteriaQuery.select(root).where(finalPredicate);

        TypedQuery<Courier> query = entityManager.createQuery(criteriaQuery);

        List<Courier> list = query.getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}
