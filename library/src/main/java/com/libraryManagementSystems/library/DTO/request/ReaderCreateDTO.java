package com.libraryManagementSystems.library.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * DTO для создания читателя.
 * Не включает id (генерируется автоматически).
 */
public record ReaderCreateDTO(
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = "Имя читателя должно содержать только буквы")
    String name,

    @NotBlank(message = "Email is required")
    String email,

    @NotBlank(message = "Phone is required")
    @Pattern(regexp = "^\\+373\\d{8}$", message = "Ошибка: Неверный формат телефона (+373XXXXXXXX)")
    String phone
) {}
