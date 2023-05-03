package edu.pet.tasktrackerapi.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Ответ сервера на запрос регистрации/аутентификации")
public class AuthenticationResponse {
    @Schema(description = "JWT-токен")
    private String token;
}
