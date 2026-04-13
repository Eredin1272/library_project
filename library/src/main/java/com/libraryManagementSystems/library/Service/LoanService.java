package com.libraryManagementSystems.library.Service;

import com.libraryManagementSystems.library.Model.Book;
import com.libraryManagementSystems.library.Model.Loan;
import com.libraryManagementSystems.library.Model.Reader;
import com.libraryManagementSystems.library.Repository.BookRepository;
import com.libraryManagementSystems.library.Repository.LoanRepository;
import com.libraryManagementSystems.library.Repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LoanService {

    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final ReaderRepository readerRepository;

    // Выдача книги
    public Loan issueBook(Long bookId, Long readerId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Книга не найдена!"));

        if (!book.isAvailable()) {
            throw new RuntimeException("Книга уже выдана");
        }

        Reader reader = readerRepository.findById(readerId)
                .orElseThrow(() -> new RuntimeException("Читатель не найден!"));

        List<Loan> readerLoans = loanRepository.findByReaderIdAndReturnDateIsNull(readerId);

        if (readerLoans.size() >= 3) {
            throw new RuntimeException("Читатель свой достиг максимум выдачи - 3 книги!");
        }
        book.setAvailable(false);
        bookRepository.save(book);

        Loan loan = new Loan(); // Создаем "пустой" объект выдачи
        loan.setBook(book);     // Привязываем книгу
        loan.setReader(reader); // Привязываем читателя
        loan.setIssueDate(LocalDate.now()); // Ставим сегодняшнюю дату
        loan.setReturnDate(null);

        return  loanRepository.save(loan);
    }

    // Возврат книги
    public Loan returnBook(Long loanId) {
        Loan loan = loanRepository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Выдача книги не найдена!"));

        if (loan.getReturnDate() != null) {
            throw new RuntimeException("Книга уже возвращена");
        }

        loan.setReturnDate(LocalDate.now());

        Book book = loan.getBook();
        book.setAvailable(true);
        bookRepository.save(book);
        return loanRepository.save(loan);
    }

    // Все выдачи
    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public boolean hasActiveLoans(Long readerId) {
        return !loanRepository
                .findByReaderIdAndReturnDateIsNull(readerId)
                .isEmpty();
    }

    // Поиск выдачи
//    public List<Loan> searchLoan(String keyword) {
//
//        if (keyword == null || keyword.trim().isEmpty()) {
//            return loanRepository.findAll();
//        }
//
//        return loanRepository
//                .findByBook_TitleContainingIgnoreCaseOrReader_NameContainingIgnoreCase(
//                        keyword.trim(), keyword.trim()
//                );
//    }
}
