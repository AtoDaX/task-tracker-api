package edu.pet.tasktrackerapi.api.service;

import edu.pet.tasktrackerapi.api.dto.TaskDto;
import edu.pet.tasktrackerapi.api.model.Task;
import edu.pet.tasktrackerapi.api.model.User;
import edu.pet.tasktrackerapi.repository.TaskRepository;
import edu.pet.tasktrackerapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final ModelMapper modelMapper;


    public List<TaskDto> getUsersTasksDto(User user){
        System.out.println(getUsersTasksEntities(user));
        return modelMapper.map(
                getUsersTasksEntities(user),
                new TypeToken<List<TaskDto>>(){}.getType()
        );
    }
    public List<Task> getUsersTasksEntities(User user){
        return taskRepository.getTasksByUser_Id(user.getId());
    }
    @Transactional
    public void deleteTask(User user, UUID uuid){
        System.out.println(user);
        if (taskRepository.existsByUserAndId(user, uuid)){
            System.out.println("ts l39");
            deleteTaskByUUID(uuid);
        } else {
            throw new NotFoundException("No task with such id");
        }
    }


    private void deleteTaskByUUID(UUID uuid){
        taskRepository.deleteTaskById(uuid);
    }


    public UUID createTask(User user, TaskDto taskDto){
        Task newTask = Task
                .builder()
                .title(taskDto.getTitle())
                .details(taskDto.getDetails())
                .completed(false)
                .user(user)
                .build();
        return taskRepository.save(newTask).getId();
    }
}
