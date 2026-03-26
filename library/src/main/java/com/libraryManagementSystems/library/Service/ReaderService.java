package com.libraryManagementSystems.library.Service;

import com.libraryManagementSystems.library.Model.Reader;
import com.libraryManagementSystems.library.Repository.ReaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;

    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    public void deleteReader(Long id) {
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
}
