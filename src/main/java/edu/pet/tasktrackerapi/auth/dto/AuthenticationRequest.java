package edu.pet.tasktrackerapi.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.models.parameters.RequestBody;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Информация о запросе на аутентификацию")
public class AuthenticationRequest extends RequestBody {
    @NotBlank
    @Schema(description = "Имя пользователя")
    private String username;
    @NotBlank
    @Schema(description = "Пароль, зашифрован BCrypt")
    private String password;
}
