package com.libraryManagementSystems.library.DTO.response;

/**
 * DTO для ответа с данными о книге.
 * Клиент видит только нужные поля, без внутренней логики.
 */
public record BookDTO(
    Long id,
    String title,
    String author,
    String isbn,
    boolean available
) {}
