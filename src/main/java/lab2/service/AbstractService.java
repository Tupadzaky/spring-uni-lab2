package lab2.service;

import java.util.List;

import lab2.model.Grade;

public interface AbstractService<T> {
    T save(T entity);

    List<T> findAll();

    T findById(Long id);
}
