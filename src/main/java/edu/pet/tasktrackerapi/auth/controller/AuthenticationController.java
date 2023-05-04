package edu.pet.tasktrackerapi.auth.controller;

import edu.pet.tasktrackerapi.auth.dto.AuthenticationRequest;
import edu.pet.tasktrackerapi.auth.dto.AuthenticationResponse;
import edu.pet.tasktrackerapi.auth.dto.RegisterRequest;
import edu.pet.tasktrackerapi.auth.service.AuthenticationService;
import edu.pet.tasktrackerapi.exception.BadCredentialsException;
import edu.pet.tasktrackerapi.exception.UserExistsException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "JWT-security", description = "Methods for registration and authentication")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @Operation(description = "New user registration",
    responses = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Getting JWT-token after successful registration",
                    content = @Content(
                            mediaType = "application/json",
                            examples = {
                                    @ExampleObject(
                                            value = """
                                                    {
                                                        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGFtcGxlIiwiaWF0IjoxNjgzMDc2MzUwLCJleHAiOjE2ODMwNzc3OTB9.gg4XpZ7HMqSbCjV4eBw7Wluoe2D23goB68D9gxG-ntM"
                                                    }"""
                                    )
                            }
                    )
            )
        })
    @PostMapping(value = "/register", produces="application/json")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest registerRequest
    ) {
        if (authenticationService.userExists(registerRequest.getUsername())){
            throw new UserExistsException();
        }
        return ResponseEntity.ok(authenticationService.register(registerRequest));
    }

    @Operation(description = "Аутентификация пользователя",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Getting JWT-token after successful authentication",
                            content = @Content(
                                    mediaType = "application/json",
                                    examples = {
                                            @ExampleObject(
                                                    value = """
                                                            {
                                                                "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJleGFtcGxlIiwiaWF0IjoxNjgzMDc2MzUwLCJleHAiOjE2ODMwNzc3OTB9.gg4XpZ7HMqSbCjV4eBw7Wluoe2D23goB68D9gxG-ntM"
                                                            }"""
                                            )
                                    }
                            )
                    )
            })
    @PostMapping(value = "/authenticate", produces="application/json")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest
    ) {
        if (!authenticationService.userExists(authenticationRequest.getUsername())){
            throw new BadCredentialsException();
        }
        return ResponseEntity.ok(authenticationService.authenticate(authenticationRequest));
    }
}


