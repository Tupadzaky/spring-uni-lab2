package lab2.service;

import java.util.List;

public interface AbstractService<T> {
    T save(T entity);

    List<T> findAll();

    T findById(Long id);
}
