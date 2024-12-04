package com.app.todo.Repository;

import com.app.todo.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
    Optional<Task> findById(Long id);
    void deleteById(Long id);

}
