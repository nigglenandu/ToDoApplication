package com.app.todo.Service;

import com.app.todo.Entity.Task;

import java.util.List;

public interface IService{
    List<Task> getAllTasks();
    void createTask(String title);

    void deleteTask(Long id);

    void toggleTask(Long id);
}
