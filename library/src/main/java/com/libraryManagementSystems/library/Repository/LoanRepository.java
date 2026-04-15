package com.libraryManagementSystems.library.Repository;

import com.libraryManagementSystems.library.Model.Book;
import com.libraryManagementSystems.library.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository <Loan, Long> {

    List<Loan> findByReaderIdAndReturnDateIsNull(Long readerId);

    // Удалить все выдачи, связанные с конкретной книгой
    void deleteByBookId(Long bookId);

    // Удалить все выдачи, связанные с конкретным читателем
    void deleteByReaderId(Long readerId);

}

