package com.libraryManagementSystems.library.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "Readers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false, name = "name")
    private String name;

    @NotBlank(message = "Email is required")
    @Column(nullable = false, name = "email")
    private String email;

    @NotBlank(message = "Phone is required")
    @Column(nullable = false, name = "phone")
    private String phone;
}