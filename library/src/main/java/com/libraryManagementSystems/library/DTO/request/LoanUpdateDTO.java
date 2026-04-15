package com.libraryManagementSystems.library.DTO.request;

import java.time.LocalDate;

/**
 * DTO для обновления выдачи.
 * Можно изменить только returnDate (при возврате книги).
 */
public record LoanUpdateDTO(
    LocalDate returnDate
) {}
