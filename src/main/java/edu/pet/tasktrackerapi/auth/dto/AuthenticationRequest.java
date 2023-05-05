package edu.pet.tasktrackerapi.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Information about authentication request")
public class AuthenticationRequest {
    @NotBlank
    @Schema(description = "Email")
    private String username;
    @NotBlank
    @Schema(description = "Password")
    private String password;
}
