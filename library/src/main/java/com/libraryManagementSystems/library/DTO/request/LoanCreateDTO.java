package com.libraryManagementSystems.library.DTO.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * DTO для выдачи книги.
 * Включает ID книги и читателя вместо целых объектов.
 * returnDate не указывается — устанавливается при возврате.
 */
public record LoanCreateDTO(
    @NotNull(message = "Book ID is required")
    Long bookId,

    @NotNull(message = "Reader ID is required")
    Long readerId,

    @NotNull(message = "Issue date is required")
    LocalDate issueDate
) {}
