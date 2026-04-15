package com.libraryManagementSystems.library.DTO.response;

/**
 * DTO для ответа с данными о читателе.
 */
public record ReaderDTO(
    Long id,
    String name,
    String email,
    String phone
) {}
