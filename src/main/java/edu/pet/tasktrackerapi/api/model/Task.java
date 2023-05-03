package edu.pet.tasktrackerapi.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.util.UUID;

@Entity
@Data

public class Task {
    @NotNull
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NotBlank
    @Column(nullable = false)
    private String title;
    @NotNull
    @Column(nullable = false)
    private String details;
    @Column(nullable = false)
    private boolean completed;
    @NotNull

    @ManyToOne
    private User owner;


}
