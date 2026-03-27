package com.libraryManagementSystems.library.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

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
    @Column(nullable = false, name = "title")
    private String title;

    @NotBlank(message = "Author is required")
    @Column(nullable = false, name = "author")
    private String author;

    @NotBlank(message = "ISBN is required")
    @Column(nullable = false, name = "isbn")
    private String isbn;

    @Column(nullable = false, name = "available")
    private boolean available = true;


}