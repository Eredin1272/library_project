package com.libraryManagementSystems.library.DTO.response;

import java.time.LocalDate;

/**
 * DTO для ответа с данными о выдаче.
 * Вместо объектов Book и Reader включаем только нужную информацию.
 */
public record LoanDTO(
    Long id,
    Long bookId,
    String bookTitle,
    String bookAuthor,
    Long readerId,
    String readerName,
    LocalDate issueDate,
    LocalDate returnDate
) {}
