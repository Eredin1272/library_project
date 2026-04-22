package com.libraryManagementSystems.library.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table(name = "Books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Название книги обязательно!")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = "Название книги может содержать только буквы и пробелы")
    @Column(nullable = false, name = "title")
    private String title;

    @NotBlank(message = "Имя автора обязательно!")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ.\\s]+$", message = "Поле Автор может содержать только буквы, пробелы и точки!")
    @Column(nullable = false, name = "author")
    private String author;

    @NotBlank(message = "Поле ISBN обязательно!")
    @Pattern(regexp = "^(\\d{10}|\\d{13})$", message = "Поле ISBN может содержать 10 или 13 цифр")
    @Column(nullable = false, name = "isbn")
    private String isbn;

    @Column(nullable = false, name = "available")
    private boolean available = true;

}