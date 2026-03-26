package com.libraryManagementSystems.library.Model;

import jakarta.persistence.*;
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

    @Column(nullable = false, name = "title")
    private String title;

    @Column(nullable = false, name = "author")
    private String author;

    @Column(nullable = false, name = "isbn")
    private String isbn;

    @Column(nullable = false, name = "available")
    private boolean available = true;
}