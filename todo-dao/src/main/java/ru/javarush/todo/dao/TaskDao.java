package ru.javarush.todo.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.todo.entity.Task;

import java.util.List;

@Repository
public interface TaskDao {

    List<Task> getAll(int offset, int limit);

    @Transactional(propagation = Propagation.REQUIRED)
    int getAllCount();

    @Transactional(propagation = Propagation.REQUIRED)
    Task getById(int id);

    @Transactional(propagation = Propagation.REQUIRED)
    void saveOrUpdate(Task task);

    @Transactional(propagation = Propagation.REQUIRED)
    void delete(Task task);
}
