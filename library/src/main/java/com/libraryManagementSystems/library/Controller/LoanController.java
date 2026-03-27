package com.libraryManagementSystems.library.Controller;

import com.libraryManagementSystems.library.Service.BookService;
import com.libraryManagementSystems.library.Service.LoanService;
import com.libraryManagementSystems.library.Service.ReaderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        model.addAttribute("books", bookService.getAllBooks());
        model.addAttribute("readers", readerService.getAllReaders());
        return "issue-form";
    }

    // выдать книгу
    @PostMapping("/issue")
    public String issueBook(@RequestParam Long bookId,
                            @RequestParam Long readerId) {
        loanService.issueBook(bookId, readerId);
        return "redirect:/loans";
    }

    // вернуть книгу
    @GetMapping("/return/{id}")
    public String returnBook(@PathVariable Long id) {
        loanService.returnBook(id);
        return "redirect:/loans";
    }
}
