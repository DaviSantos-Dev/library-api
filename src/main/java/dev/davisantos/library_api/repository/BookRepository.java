package dev.davisantos.library_api.repository;

import dev.davisantos.library_api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
