package com.libraryManagementSystems.library.Controller;

import com.libraryManagementSystems.library.Model.Reader;
import com.libraryManagementSystems.library.Service.LoanService;
import com.libraryManagementSystems.library.Service.ReaderService;
import com.libraryManagementSystems.library.dto.ReaderFormDTO;
import com.libraryManagementSystems.library.mapper.ReaderMapper;
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
        model.addAttribute("readers", readerService.getAllReaders()
                .stream()
                .map(ReaderMapper::toViewDTO)
                .toList());
        model.addAttribute("loanService", loanService);
        return "readers";
    }

    @GetMapping("/new")
    public String createReaderForm(Model model) {
        model.addAttribute("reader", new ReaderFormDTO());
        return "reader-form";
    }

    @PostMapping
    public String saveReader(@Valid @ModelAttribute("reader") ReaderFormDTO dto, // Valid - Проврка на соответсвие вссем правилам валидации
                             BindingResult result) { // BindingResult - Если данные прошли проверку — result.hasErrors() вернет false.
        if (result.hasErrors()) {                    // Если хотя бы одно поле нарушило правила (например, имя осталось пустым) — result.hasErrors() вернет true.
            return "reader-form";
        }
        // Если ошибок нет — конвертируем DTO в Entity и сохраняем
        readerService.saveReader(ReaderMapper.toEntity(dto));
        return "redirect:/readers";
    }

    // Изменить данные читателя
    @GetMapping("/edit/{id}")
    public String editReader(@PathVariable Long id, Model model) {

        Reader reader = readerService.getReaderById(id);
        model.addAttribute("reader", ReaderMapper.toFormDTO(reader));
        return "reader-form";
    }

    // Принять изменения
    @PostMapping("/update/{id}")
    public String updateReader(@PathVariable Long id,
                               @Valid @ModelAttribute("reader") ReaderFormDTO dto,
                               BindingResult result) {

        if (result.hasErrors()) {
            return "reader-form";
        }

        readerService.updateReader(id, ReaderMapper.toEntity(dto));
        return "redirect:/readers";
    }


    @GetMapping("/delete/{id}")
    public String deleteReader(@PathVariable Long id) { // Идентификация конкретного ресурса (Книга №10).
        readerService.deleteReader(id);
        return "redirect:/readers";
    }

    @GetMapping("/search")
    public String searchReaders(@RequestParam String keyword, Model model) { // books?genre=fantasy — Фильтрация или поиск.
        model.addAttribute("readers", readerService.searchReaders(keyword));
        model.addAttribute("loanService", loanService);

        return "readers";
    }





}
