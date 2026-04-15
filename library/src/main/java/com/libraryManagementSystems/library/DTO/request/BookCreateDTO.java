package com.libraryManagementSystems.library.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * DTO для создания книги.
 * Не включает id (генерируется автоматически) и available (по умолчанию true).
 */
public record BookCreateDTO(
    @NotBlank(message = "Title is required")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = "Title must contain only letters")
    String title,

    @NotBlank(message = "Author is required")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ.\\s]+$", message = "Author must contain only letters, spaces and dots")
    String author,

    @NotBlank(message = "ISBN is required")
    @Pattern(regexp = "^(\\d{10}|\\d{13})$", message = "ISBN must contain exactly 10 or 13 digits")
    String isbn
) {}
