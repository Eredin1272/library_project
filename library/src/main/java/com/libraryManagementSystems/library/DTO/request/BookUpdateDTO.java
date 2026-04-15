package com.libraryManagementSystems.library.DTO.request;

import jakarta.validation.constraints.Pattern;

/**
 * DTO для обновления книги.
 * Все поля опциональны — можно менять только то, что нужно.
 * Валидация применяется только если поле передано.
 */
public record BookUpdateDTO(
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = "Title must contain only letters")
    String title,

    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ.\\s]+$", message = "Author must contain only letters, spaces and dots")
    String author,

    @Pattern(regexp = "^(\\d{10}|\\d{13})$", message = "ISBN must contain exactly 10 or 13 digits")
    String isbn,

    Boolean available
) {}
