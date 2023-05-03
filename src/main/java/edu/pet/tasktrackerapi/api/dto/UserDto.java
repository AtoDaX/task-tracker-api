package edu.pet.tasktrackerapi.api.dto;

import edu.pet.tasktrackerapi.api.model.User;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link User} entity
 */
@Data
public class UserDto implements Serializable {
    private final Long id;
    private final String username;
    private final List<TaskDto> tasks;
}