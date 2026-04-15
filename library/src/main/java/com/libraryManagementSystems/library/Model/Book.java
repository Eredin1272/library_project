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

    @NotBlank(message = "Title is required")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ\\s]+$", message = "Title must contain only letters")
    @Column(nullable = false, name = "title")
    private String title;

    @NotBlank(message = "Author is required")
    @Pattern(regexp = "^[a-zA-Zа-яА-ЯёЁ.\\s]+$", message = "Author must contain only letters, spaces and dots")
    @Column(nullable = false, name = "author")
    private String author;

    @NotBlank(message = "ISBN is required")
    @Pattern(regexp = "^(\\d{10}|\\d{13})$", message = "ISBN must contain exactly 10 or 13 digits")
    @Column(nullable = false, name = "isbn")
    private String isbn;

    @Column(nullable = false, name = "available")
    private boolean available = true;


}