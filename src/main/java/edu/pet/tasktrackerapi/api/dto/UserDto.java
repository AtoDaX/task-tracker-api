package edu.pet.tasktrackerapi.api.dto;

import edu.pet.tasktrackerapi.api.model.User;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link User} entity
 */
@Data
@RequiredArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private List<TaskDto> tasks;
}