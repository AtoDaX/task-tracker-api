package edu.pet.tasktrackerapi.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Schema(description = "Information about new Task")
public class NewTaskRequest implements Serializable {
    @NotBlank
    private final String title;
    @NotNull
    private final String details;
}
