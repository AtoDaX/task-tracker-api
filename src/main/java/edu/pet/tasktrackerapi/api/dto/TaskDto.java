package edu.pet.tasktrackerapi.api.dto;

import edu.pet.tasktrackerapi.api.model.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link Task} entity
 */
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Schema(description = "Information about Task")
public class TaskDto implements Serializable{

    private UUID id;
    @NotBlank
    private final String title;
    @NotNull
    private final String details;
    private boolean completed;
}