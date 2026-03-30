package com.libraryManagementSystems.library.Repository;

import com.libraryManagementSystems.library.Model.Book;
import com.libraryManagementSystems.library.Model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {

    List<Book> findByTitleContainingIgnoreCase(String title);

    List<Book> findByAuthorContainingIgnoreCase(String author);

    List<Book> findByTitleContainingIgnoreCaseOrAuthorContainingIgnoreCase(String title, String author);

    List<Book> findByAvailableTrue();
}
