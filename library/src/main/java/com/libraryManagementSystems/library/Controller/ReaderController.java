package com.libraryManagementSystems.library.Controller;

import com.libraryManagementSystems.library.Model.Reader;
import com.libraryManagementSystems.library.Service.LoanService;
import com.libraryManagementSystems.library.Service.ReaderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/readers")
public class ReaderController {
    private final ReaderService readerService;
    @Autowired
    private LoanService loanService;

    @GetMapping
    public String getAllReaders(Model model) {
        model.addAttribute("readers", readerService.getAllReaders());
        model.addAttribute("loanService", loanService);
        return "readers";
    }

    @GetMapping("/new")
    public String createReaderForm(Model model) {
        model.addAttribute("reader", new Reader());
        return "reader-form";
    }

    @PostMapping
    public String saveReader(@Valid @ModelAttribute Reader reader, BindingResult result) {

        if (result.hasErrors()) {
            return "reader-form"; // обратно в форму
        }

        readerService.saveReader(reader);
        return "redirect:/readers";
    }

    // Изменить данные читателя
    @GetMapping("/edit/{id}")
    public String editReader(@PathVariable Long id, Model model) {

        Reader reader = readerService.getReaderById(id);
        model.addAttribute("reader", reader);
        return "reader-form";
    }

    // Принять изменения
    @PostMapping("/update/{id}")
    public String updateReader(@PathVariable Long id, @ModelAttribute("reader") Reader reader) {
        readerService.updateReader(id, reader);
        return "redirect:/readers"; // Перенаправляем на список всех читателей после сохранения
    }


    @GetMapping("/delete/{id}")
    public String deleteReader(@PathVariable Long id) {
        readerService.deleteReader(id);
        return "redirect:/readers";
    }

    @GetMapping("/search")
    public String searchReaders(@RequestParam String keyword, Model model) {
        model.addAttribute("readers", readerService.searchReaders(keyword));
        model.addAttribute("loanService", loanService);

        return "readers";
    }





}
