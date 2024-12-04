package com.app.todo.Service;

import com.app.todo.Entity.Task;
import com.app.todo.Repository.TaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements IService {

    @Autowired
    private TaskRepo repo;

    @Override
    public List<Task> getAllTasks() {
        return repo.findAll();
    }

    @Override
    public void createTask(String title) {
        Task task = new Task();
        task.setTitle(title);
        task.setCompleted(false);
        repo.save(task);
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        repo.deleteById(id);
    }


    @Override
    public void toggleTask(Long id) {
        Task task = repo.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
        task.setCompleted(!task.getCompleted());
        repo.save(task);
    }
}
