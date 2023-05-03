package edu.pet.tasktrackerapi.api.dto;

import edu.pet.tasktrackerapi.api.model.Task;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link Task} entity
 */
@Data
public class TaskDto implements Serializable {
    @NotNull
    private final UUID id;
    @NotBlank
    private final String title;
    @NotNull
    private final String details;
    private final boolean completed;
}