package com.libraryManagementSystems.library.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReaderViewDTO {
    private Long id;
    private String name;
    private String email;
    private String phone;
}