package com.libraryManagementSystems.library.Controller;

import com.libraryManagementSystems.library.Model.Loan;
import com.libraryManagementSystems.library.Service.BookService;
import com.libraryManagementSystems.library.Service.LoanService;
import com.libraryManagementSystems.library.Service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/loans")

public class LoanController {
    private final LoanService loanService;
    private final BookService bookService;
    private final ReaderService readerService;

    // список выдач
    @GetMapping
    public String getAllLoans(Model model) {
        model.addAttribute("loans", loanService.getAllLoans());
        return "loans";
    }

    // форма выдачи
    @GetMapping("/issue")
    public String issueForm(Model model) {
        model.addAttribute("books", bookService.getAvailableBooks());
        model.addAttribute("readers", readerService.getAllReaders());
        return "issue-form";
    }

    // выдать книгу
    @PostMapping("/issue")
    public String issueBook(@RequestParam(required = false) Long bookId,
                            @RequestParam(required = false) Long readerId,
                            Model model) {

        if (bookId == null || readerId == null) {
            model.addAttribute("error", "Выберите книгу и читателя");
            model.addAttribute("books", bookService.getAvailableBooks());
            model.addAttribute("readers", readerService.getAllReaders());
            return "issue-form";
        }

        try {
            loanService.issueBook(bookId, readerId);
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("books", bookService.getAvailableBooks());
            model.addAttribute("readers", readerService.getAllReaders());
            return "issue-form";
        }

        return "redirect:/loans";
    }

    // вернуть книгу
    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable Long id) {
        loanService.returnBook(id);
        return "redirect:/loans";
    }

    @GetMapping("/loans")
    public String getLoans(@RequestParam(required = false) String keyword, Model model) {

        List<Loan> loans;

        if (keyword != null && !keyword.trim().isEmpty()) {
            loans = loanService.searchLoan(keyword);
        } else {
            loans = loanService.getAllLoans();
        }

        model.addAttribute("loans", loans);
        model.addAttribute("keyword", keyword);

        return "loans";
    }
}
