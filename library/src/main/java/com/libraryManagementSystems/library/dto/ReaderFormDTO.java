package com.libraryManagementSystems.library.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ReaderFormDTO {

    private Long id;

    @NotBlank(message = "Имя читателя обязательно!")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = "Имя должно содержать только буквы")
    private String name;

    @NotBlank(message = "Email обязателен!")
    private String email;

    @NotBlank(message = "Номер телефона обязателен!")
    @Pattern(regexp = "^\\+373\\d{8}$", message = "Формат: +373XXXXXXXX")
    private String phone;
}