package com.libraryManagementSystems.library.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

    @NotBlank(message = "Имя читателя обязательно!")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = " Имя читателя должно содержать только буквы!")
    @Column(nullable = false, name = "name")
    private String name;

    @NotBlank(message = "Email обязателен!")
    @Column(nullable = false, name = "email")
    private String email;

    @NotBlank(message = "Номер телефона обязателен!")
    @Pattern(regexp = "^\\+373\\d{8}$", message = " Ошибка: Неверный формат телефона (+373XXXXXXXX)")
    @Column(nullable = false, name = "phone")
    private String phone;
}