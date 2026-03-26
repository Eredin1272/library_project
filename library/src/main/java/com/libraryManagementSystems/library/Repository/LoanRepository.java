package com.libraryManagementSystems.library.Repository;

import com.libraryManagementSystems.library.Model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends JpaRepository <Loan, Long> {

    // Найти все активные выдачи книги
    List<Loan> findByBookIdAndReturnDateIsNull(Long bookId);

    // Найти все активные выдачи читателя
    List<Loan> findByReaderIdAndReturnDateIsNull(Long readerId);

}
