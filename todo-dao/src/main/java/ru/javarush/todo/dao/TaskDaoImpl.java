package ru.javarush.todo.dao;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import ru.javarush.todo.entity.Task;

import java.util.List;

@Repository
@AllArgsConstructor
public class TaskDaoImpl implements TaskDao {

    private final SessionFactory sessionFactory;

    @Override
    public List<Task> getAll(int offset, int limit) {
        Query<Task> query = getSession().createQuery("select t from Task t", Task.class);
        query.setFirstResult(offset);
        query.setMaxResults(limit);
        return query.getResultList();
    }

    @Override
    public int getAllCount() {
        Query<Long> query = getSession().createQuery("select count(t) from Task t", Long.class);
        return Math.toIntExact(query.uniqueResult());
    }

    @Override
    public Task getById(int id) {
        Query<Task> query = getSession().createQuery("select t from Task t where t.id = :ID", Task.class);
        query.setParameter("ID", id);
        return query.uniqueResult();
    }

    @Override
    public void saveOrUpdate(Task task) {
        getSession().persist(task);
    }

    @Override
    public void delete(Task task) {
        getSession().remove(task);
    }

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
}
