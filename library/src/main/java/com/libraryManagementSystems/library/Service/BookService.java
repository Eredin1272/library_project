package com.libraryManagementSystems.library.Service;


import com.libraryManagementSystems.library.Model.Book;
import com.libraryManagementSystems.library.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    // Получить список всех книг
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Найти книгу по ID
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
         bookRepository.deleteById(id);
    }

    public Book updateBook(Long id, Book updateBook) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book is not found"));

        book.setTitle(updateBook.getTitle());
        book.setAuthor(updateBook.getAuthor());
        book.setIsbn(updateBook.getIsbn());

        return bookRepository.save(book);
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository
                .findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(keyword, keyword);
    }

}
