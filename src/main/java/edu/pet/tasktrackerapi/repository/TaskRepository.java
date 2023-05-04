package edu.pet.tasktrackerapi.repository;

import edu.pet.tasktrackerapi.api.model.Task;
import edu.pet.tasktrackerapi.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
    List<Task> getTasksByUser_Id(Long id);

    void deleteTaskById(UUID uuid);

    int countTasksByUserAndCompleted(User user, boolean completed);


    @Transactional
    @Modifying
    @Query("UPDATE Task t SET t.title = :title, t.details = :details, t.completed = :completed WHERE t.id = :id")
    void update(@Param("id") UUID uuid, @Param("title") String title, @Param("details") String details, @Param("completed") boolean completed);


    boolean existsByUserAndId(User user, UUID uuid);
}
