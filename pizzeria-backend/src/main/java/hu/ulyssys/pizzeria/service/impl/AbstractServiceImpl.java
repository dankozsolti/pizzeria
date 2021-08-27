package hu.ulyssys.pizzeria.service.impl;

import hu.ulyssys.pizzeria.dao.CoreDAO;

import hu.ulyssys.pizzeria.entity.AbstractIdentity;
import hu.ulyssys.pizzeria.service.CoreService;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import java.util.List;

public abstract class AbstractServiceImpl<T extends AbstractIdentity> implements CoreService<T> {
    @Inject
    protected CoreDAO<T> dao;

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public List<T> getAll() {
        return dao.findAll();
    }

    @TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    @Override
    public T findById(Long id) {
        return dao.findById(id);
    }

    @Override
    public void add(T entity) {
        dao.save(entity);
    }

    @Override
    public void remove(T entity) {
        dao.delete(entity.getId());
    }

    @Override
    public void update(T entity) {
        dao.update(entity);
    }

}
