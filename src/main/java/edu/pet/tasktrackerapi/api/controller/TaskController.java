package edu.pet.tasktrackerapi.api.controller;

import edu.pet.tasktrackerapi.api.dto.NewTaskRequest;
import edu.pet.tasktrackerapi.api.dto.TaskDto;
import edu.pet.tasktrackerapi.api.model.User;
import edu.pet.tasktrackerapi.api.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
//TODO document errors
@RestController
@RequestMapping("/api/v1/tasks")
@RequiredArgsConstructor
@Tag(name = "Tasks", description = "Methods for task management")
public class TaskController {
    private final TaskService taskService;

    @GetMapping(produces = "application/json")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(description = "Getting list of tasks")
    public ResponseEntity<List<TaskDto>> getTasks(@AuthenticationPrincipal User user){
        System.out.println(taskService.getUsersTasksDto(user));
        return ResponseEntity.ok(taskService.getUsersTasksDto(user));
    }

    @PostMapping(produces = "application/json")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(description = "Creating new task")
    public ResponseEntity<UUID> createTask(@AuthenticationPrincipal User user,
                                           @RequestBody @Valid NewTaskRequest newTaskRequest){
        UUID taskId = taskService.createTask(user, newTaskRequest);
        return ResponseEntity.ok(taskId);
    }



    @PutMapping(produces = "application/json")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(description = "Updating existing task")
    public ResponseEntity<TaskDto> updateTask(@AuthenticationPrincipal User user,
                                           @RequestBody @Valid TaskDto taskDto){
        taskService.updateTaskIfBelongsToUser(user, taskDto);

        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping(path = "/{uuid}", produces = "application/json")
    @SecurityRequirement(name = "Bearer Authentication")
    @Operation(description = "Delete task by uuid")
    public ResponseEntity<UUID> deleteTask(@AuthenticationPrincipal User user,
                                     @PathVariable UUID uuid){
        taskService.deleteTask(user, uuid);

        return ResponseEntity.ok(uuid);
    }


}
