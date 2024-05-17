package dev.patika.business.abstracts;

import java.util.List;

public interface CrudService<T> {
    T getById(Long id);
    List<T> getAll();
    T save(T entity);
    T update(T entity);
    String delete(Long id);
}
