package hu.ulyssys.pizzeria.service;

import hu.ulyssys.pizzeria.entity.AbstractIdentity;

import java.util.List;

public interface CoreService<T extends AbstractIdentity> {
    List<T> getAll();

    T findById(Long id);

    void add(T entity);

    void remove(T entity);

    void update(T entity);
}
