package edu.pet.tasktrackerapi.auth.service;

import edu.pet.tasktrackerapi.auth.dto.AuthenticationRequest;
import edu.pet.tasktrackerapi.auth.dto.AuthenticationResponse;
import edu.pet.tasktrackerapi.auth.dto.RegisterRequest;
import edu.pet.tasktrackerapi.api.model.Role;
import edu.pet.tasktrackerapi.api.model.User;
import edu.pet.tasktrackerapi.exception.BadCredentialsException;
import edu.pet.tasktrackerapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        var user = User.
                builder()
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        var user = userRepository.findByUsername(authenticationRequest.getUsername())
                .get();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .build();
    }

    public boolean userExists(String username){
        return userRepository.existsUserByUsername(username);
    }

    public boolean isCredentialsValid(AuthenticationRequest authenticationRequest) {

        String reqUsername = authenticationRequest.getUsername();
        String reqPassword = authenticationRequest.getPassword();
        String dbPassword = userRepository.findByUsername(reqUsername)
                .orElseThrow((Supplier<BadCredentialsException>) BadCredentialsException::new).getPassword();

        return passwordEncoder.matches(reqPassword, dbPassword);
    }
}
