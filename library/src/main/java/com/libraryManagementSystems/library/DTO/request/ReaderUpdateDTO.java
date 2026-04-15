package com.libraryManagementSystems.library.DTO.request;

import jakarta.validation.constraints.Pattern;

/**
 * DTO для обновления читателя.
 * Все поля опциональны — можно менять только то, что нужно.
 */
public record ReaderUpdateDTO(
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = "Имя читателя должно содержать только буквы")
    String name,

    String email,

    @Pattern(regexp = "^\\+373\\d{8}$", message = "Ошибка: Неверный формат телефона (+373XXXXXXXX)")
    String phone
) {}
