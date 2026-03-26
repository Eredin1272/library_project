package com.libraryManagementSystems.library.Repository;

import com.libraryManagementSystems.library.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository <Book, Long> {
}
//sdd