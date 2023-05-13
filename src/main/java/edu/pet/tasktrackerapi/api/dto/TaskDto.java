package edu.pet.tasktrackerapi.api.dto;

import edu.pet.tasktrackerapi.api.model.Task;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * A DTO for the {@link Task} entity
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Information about Task")
public class TaskDto implements Serializable{

    private UUID id;
    @NotBlank
    private String title;
    @NotNull
    private String details;
    private boolean completed;
}