package com.libraryManagementSystems.library.mapper;

import com.libraryManagementSystems.library.Model.Book;
import com.libraryManagementSystems.library.dto.BookFormDTO;
import com.libraryManagementSystems.library.dto.BookViewDTO;
import lombok.Builder;


@Builder
public class BookMapper {

    // DTO -> Entity
    public static Book toEntity(BookFormDTO dto) {
        return Book.builder() // .builder() — инициализирует процесс сборки объекта через паттерн "Строитель"
                .id(dto.getId())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .isbn(dto.getIsbn())
                .available(true)
                .build(); // Финальный шаг: создаем и возвращаем готовый объект Book
    }

    /**
     * Преобразует сущность (Entity) в объект для отображения (View DTO).
     * Используется, когда нужно отправить данные о книге на фронтенд.
     */
    public static BookViewDTO toViewDTO(Book book) {
        return BookViewDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .available(book.isAvailable()) // Здесь мы берем реальный статус из базы
                .build();

    }

    /**
     * Преобразует сущность в DTO для формы редактирования.
     * Отличие от ViewDTO в том, что здесь может быть меньше полей
     * (например, те, которые пользователь имеет право менять).
     */
    public static BookFormDTO toFormDTO(Book book) {
        return BookFormDTO.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .isbn(book.getIsbn())
                .build();
    }
}