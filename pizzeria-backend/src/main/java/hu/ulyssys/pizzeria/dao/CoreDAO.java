package hu.ulyssys.pizzeria.dao;

import hu.ulyssys.pizzeria.entity.AbstractIdentity;

import java.util.List;

public interface CoreDAO<T extends AbstractIdentity> {
    List<T> findAll();

    T findById(Long id);

    T save(T entity);

    T update(T entity);

    void delete(Long id);
}
