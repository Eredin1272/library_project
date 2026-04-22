package com.libraryManagementSystems.library.Controller;

import com.libraryManagementSystems.library.Model.Book;
import com.libraryManagementSystems.library.Service.BookService;
import com.libraryManagementSystems.library.dto.BookFormDTO;
import com.libraryManagementSystems.library.mapper.BookMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    //  список книг
    @GetMapping
    public String getAllBooks(Model model) {
        model.addAttribute("books",
                bookService.getAllBooks()// Исходные данные (список)
                        .stream()// Открывает поток
                        .map(BookMapper::toViewDTO) // Трансформация
                        .toList() // Собирает данные обратно в список
        );
        return "books";
    }

    //  форма добавления
    @GetMapping("/new")
    public String createBookForm(Model model) {
        model.addAttribute("book", new BookFormDTO());
        return "book-form";
    }

    //  сохранить книгу
    @PostMapping
    public String saveBook(@Valid @ModelAttribute("book") BookFormDTO dto, BindingResult result) {

        if (result.hasErrors()) {
            return "book-form"; // обратно в форму
        }

        bookService.saveBook(BookMapper.toEntity(dto));
        return "redirect:/books";
    }

    //  редактирование
    @GetMapping("/edit/{id}")
    public String editBook(@PathVariable Long id, Model model) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", BookMapper.toFormDTO(book));
        return "book-form";
    }

    // Обновление
    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id,
                             @Valid @ModelAttribute("book") BookFormDTO dto,
                             BindingResult result) {

        if (result.hasErrors()) {
            return "book-form";
        }

        bookService.updateBook(id, BookMapper.toEntity(dto));
        return "redirect:/books";
    }

    //  удалить
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String keyword, Model model) {
        model.addAttribute("books", bookService.searchBooks(keyword));
        return "books";
    }

}
