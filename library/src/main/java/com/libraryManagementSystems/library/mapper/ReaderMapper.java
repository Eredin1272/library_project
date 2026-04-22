package com.libraryManagementSystems.library.mapper;

import com.libraryManagementSystems.library.Model.Reader;
import com.libraryManagementSystems.library.dto.ReaderFormDTO;
import com.libraryManagementSystems.library.dto.ReaderViewDTO;
import lombok.Builder;


@Builder
public class ReaderMapper {

    /**
     * Преобразование DTO из формы в сущность Reader (Entity).
     * Используется, когда мы получаем данные от пользователя
     * и хотим подготовить их для сохранения в базу данных.
     */
    public static Reader toEntity(ReaderFormDTO dto) {
        return Reader.builder()
                .id(dto.getId()) // Передаем уникальный идентификатор
                .name(dto.getName())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build(); // "Склеиваем" все поля в готовый объект Reader
    }

    /**
     * Преобразование сущности Reader в ViewDTO.
     * Используется для безопасной отправки данных клиенту (например, в список читателей).
     * Здесь мы отдаем только те поля, которые разрешено видеть.
     */
    public static ReaderViewDTO toViewDTO(Reader reader) {
        return ReaderViewDTO.builder()
                .id(reader.getId())
                .name(reader.getName())
                .email(reader.getEmail())
                .phone(reader.getPhone())
                .build();
    }

    /**
     * Преобразование сущности Reader обратно в FormDTO.
     * Чаще всего используется для заполнения полей формы при редактировании профиля.
     * В отличие от BookMapper, здесь ты уже используешь .builder(), что гораздо круче!
     */
    public static ReaderFormDTO toFormDTO(Reader reader) {
        return ReaderFormDTO.builder()
                .id(reader.getId())
                .name(reader.getName())
                .email(reader.getEmail())
                .phone(reader.getPhone())
                .build();
    }
}