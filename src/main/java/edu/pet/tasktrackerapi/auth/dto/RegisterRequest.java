package edu.pet.tasktrackerapi.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Запрос на регистрацию")
public class RegisterRequest {
    @NotBlank
    @Schema(description = "Имя пользователя")
    private String username;
    @NotBlank
    @Schema(description = "Пароль, зашифрован BCryptPasswordEncoder")
    private String password;
}
