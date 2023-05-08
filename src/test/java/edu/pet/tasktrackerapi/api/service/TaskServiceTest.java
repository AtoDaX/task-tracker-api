package edu.pet.tasktrackerapi.api.service;

import edu.pet.tasktrackerapi.api.dto.NewTaskRequest;
import edu.pet.tasktrackerapi.api.model.Task;
import edu.pet.tasktrackerapi.api.model.User;
import edu.pet.tasktrackerapi.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.LogManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    private TaskRepository taskRepository;
    @Mock
    private ModelMapper modelMapper;
    private TaskService taskService;

    @BeforeEach
    void setUp(){
        taskService = new TaskService(taskRepository, modelMapper);
    }


    @Test
    void testCreateTask() {
        //given
        User user = new User();
        NewTaskRequest newTaskRequest = new NewTaskRequest();
        newTaskRequest.setTitle("Test Title");
        newTaskRequest.setDetails("Test Details");

        Task task = new Task();
        UUID taskId = UUID.randomUUID();
        task.setId(taskId);

        //when
        when(taskRepository.save(any(Task.class))).thenReturn(task);
        UUID result = taskService.createTask(user, newTaskRequest);

        //then
        assertEquals(taskId, result);
        verify(taskRepository, times(1)).save(any(Task.class));
    }

    @Test
    void getUsersTasksDto() {
    }

    @Test
    void getUsersTasksEntities() {
    }

    @Test
    void updateTaskIfBelongsToUser() {
    }

    @Test
    void updateTask() {
    }

    @Test
    void deleteTask() {
    }

    @Test
    void deleteTaskByUUID() {
    }

    @Test
    void getNumberOfNotCompletedTasks() {
    }
}