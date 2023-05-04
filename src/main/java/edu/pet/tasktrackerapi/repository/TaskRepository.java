package edu.pet.tasktrackerapi.repository;

import edu.pet.tasktrackerapi.api.model.Task;
import edu.pet.tasktrackerapi.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> getTasksByUser_Id(Long id);

    void deleteTaskById(UUID uuid);

    boolean existsByUserAndId(User user, UUID uuid);
}
