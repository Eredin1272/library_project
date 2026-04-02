package com.libraryManagementSystems.library.Repository;

import com.libraryManagementSystems.library.Model.Book;
import com.libraryManagementSystems.library.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository <Loan, Long> {

    // Найти все активные выдачи книги
    List<Loan> findByBookIdAndReturnDateIsNull(Long bookId);


    List<Loan> findByReaderIdAndReturnDateIsNull(Long readerId);

    List<Loan> findByBook_TitleContainingIgnoreCaseOrReader_NameContainingIgnoreCase(
            String bookTitle, String readerName
    );

    // Удалить все выдачи, связанные с конкретной книгой
    void deleteByBookId(Long bookId);

    // Удалить все выдачи, связанные с конкретным читателем
    void deleteByReaderId(Long readerId);
}
