package ru.javarush.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.javarush.todo.dao.TaskDao;
import ru.javarush.todo.entity.Status;
import ru.javarush.todo.entity.Task;

import java.util.List;

import static java.util.Objects.isNull;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskDao taskDao;

    @Override
    public List<Task> getAll(int offset, int limit) {
        return taskDao.getAll(offset, limit);
    }

    @Override
    public int getAllCount() {
        return taskDao.getAllCount();
    }

    @Override
    @Transactional
    public Task edit(int id, String description, Status status) {
        Task task = taskDao.getById(id);
        if (isNull(task)) {
            throw new RuntimeException("Not found");
        }
        System.out.println("start update1");
        task.setDescription(description);
        task.setStatus(status);
        taskDao.saveOrUpdate(task);
        return task;
    }

    @Override
    @Transactional
    public Task create(String description, Status status) {
        Task task = new Task();
        task.setDescription(description);
        task.setStatus(status);
        taskDao.saveOrUpdate(task);
        return task;
    }

    @Override
    @Transactional
    public void delete(int id) {
        Task task = taskDao.getById(id);
        if (isNull(task)) {
            throw new RuntimeException("Not found");
        }

        taskDao.delete(task);
    }
}
