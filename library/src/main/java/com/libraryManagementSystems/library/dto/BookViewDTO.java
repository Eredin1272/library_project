package com.libraryManagementSystems.library.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookViewDTO {
    private Long id;
    private String title;
    private String author;
    private String isbn;
    private boolean available;
}
