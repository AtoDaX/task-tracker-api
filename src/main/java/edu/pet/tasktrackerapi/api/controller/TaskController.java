package edu.pet.tasktrackerapi.api.controller;

import edu.pet.tasktrackerapi.api.dto.TaskDto;
import edu.pet.tasktrackerapi.api.model.User;
import edu.pet.tasktrackerapi.api.service.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<List<TaskDto>> getTasks(@AuthenticationPrincipal User user){
        System.out.println(taskService.getUsersTasksDto(user));
        return ResponseEntity.ok(taskService.getUsersTasksDto(user));
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<UUID> createTask(@AuthenticationPrincipal User user,
                                           @RequestBody @Valid TaskDto taskDto){
        UUID taskId = taskService.createTask(user, taskDto);
        return ResponseEntity.ok(taskId);
    }


    //TODO implement
    @PutMapping(produces = "application/json")
    public ResponseEntity<TaskDto> updateTask(@AuthenticationPrincipal User user,
                                           @RequestBody @Valid TaskDto taskDto){
        taskService.updateTaskIfBelongsToUser(user, taskDto);

        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping(path = "/{uuid}", produces = "application/json")
    public ResponseEntity<UUID> deleteTask(@AuthenticationPrincipal User user,
                                     @PathVariable UUID uuid){
        taskService.deleteTask(user, uuid);

        return ResponseEntity.ok(uuid);
    }

    @GetMapping(path = "/not-finished",produces = "application/json")

    public ResponseEntity<Integer> countNotCompleted(@AuthenticationPrincipal User user){
        Integer count = taskService.getNumberOfNotCompletedTasks(user);
        return ResponseEntity.ok(count);
    }
}
