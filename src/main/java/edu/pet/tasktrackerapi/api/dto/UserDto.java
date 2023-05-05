package edu.pet.tasktrackerapi.api.dto;

import edu.pet.tasktrackerapi.api.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link User} entity
 */
@Data
@NoArgsConstructor(force = true)
@RequiredArgsConstructor
@Schema(description = "Information about User")
public class UserDto implements Serializable {
    private final Long id;
    private final String username;
    private final List<TaskDto> tasks;
}