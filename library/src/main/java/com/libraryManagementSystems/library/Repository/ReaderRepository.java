package com.libraryManagementSystems.library.Repository;

import com.libraryManagementSystems.library.Model.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository <Reader, Long> {
}
