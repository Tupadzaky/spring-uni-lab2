package lab2.service;

import java.util.List;
import java.util.Optional;
import lab2.model.Journal;

public interface AbstractService<T> {
    T save(T entity);

    List<T> findAll();

    Optional<T> findById(Long id);
}
