package com.libraryManagementSystems.library.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // это «глобальный перехватчик» для всех контроллеров
public class GlobalExceptionHandler {


    // Book
    @ExceptionHandler(BookNotFoundException.class)
    public String handleBookNotFound(BookNotFoundException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());

        return "error";
    }

    // Global
    @ExceptionHandler(Exception.class)
    public String handleGeneral(Exception ex, Model model) {
        model.addAttribute("errorMessage", "Что-то пошло не так: " + ex.getMessage());

        return "error";
    }
}