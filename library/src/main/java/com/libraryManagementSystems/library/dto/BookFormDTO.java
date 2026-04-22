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
public class BookFormDTO {

    private Long id;

    @NotBlank(message = "Название книги обязательно!")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = "Название книги может содержать только буквы!")
    private String title;

    @NotBlank(message = "Имя Автора обязательно!")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ.\\s]+$", message = "Поле Автор может содержать только буквы и точки")
    private String author;

    @NotBlank(message = "Поле ISBN обязательно!")
    @Pattern(regexp = "^(\\d{10}|\\d{13})$", message = "Поле ISBN может содержать 10 или 13 символов!")
    private String isbn;

}
