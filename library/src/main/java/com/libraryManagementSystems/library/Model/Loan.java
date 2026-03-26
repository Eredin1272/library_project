package com.libraryManagementSystems.library.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "Loans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // какая книга
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    // какой читатель
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    private LocalDate issueDate;

    private LocalDate returnDate;
}