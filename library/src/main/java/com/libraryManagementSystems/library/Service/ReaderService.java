package com.libraryManagementSystems.library.Service;

import com.libraryManagementSystems.library.Model.Reader;
import com.libraryManagementSystems.library.Repository.LoanRepository;
import com.libraryManagementSystems.library.Repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    @Autowired
    private final ReaderRepository readerRepository;

    @Autowired
    private LoanRepository loanRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Transactional
    public void deleteReader(Long id) {

        if (!loanRepository.findByReaderIdAndReturnDateIsNull(id).isEmpty()) {
            throw new RuntimeException("Нельзя удалить читателя с книгами");
        }

        loanRepository.deleteByReaderId(id);
        readerRepository.deleteById(id);
    }

    public Reader updateReader(Long id, Reader updatetReader) {

        Reader reader = readerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Читатель не найден"));

        reader.setName(updatetReader.getName());
        reader.setEmail(updatetReader.getEmail());
        reader.setPhone(updatetReader.getPhone());

        return readerRepository.save(reader);
    }

    public List<Reader> searchReaders(String keyword) {
        return readerRepository.findByNameContainingIgnoreCase(keyword);
    }
}
