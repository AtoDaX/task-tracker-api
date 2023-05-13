package edu.pet.tasktrackerapi.api.dto;

import edu.pet.tasktrackerapi.api.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * A DTO for the {@link User} entity
 */
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@Schema(description = "Information about User")
public class UserDto implements Serializable {
    private Long id;
    private String username;
    private List<TaskDto> tasks;
}