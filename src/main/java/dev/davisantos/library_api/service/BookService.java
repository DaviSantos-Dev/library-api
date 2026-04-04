package dev.davisantos.library_api.service;

import dev.davisantos.library_api.entities.Book;
import dev.davisantos.library_api.exception.NotFoundException;
import dev.davisantos.library_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void save(Book book){
        bookRepository.save(book);
    }
    public Book findById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new NotFoundException("Book not found"));
    }
    public List<Book>  findAll(){
        return bookRepository.findAll();
    }
    public void deleteById(Long id){
        bookRepository.deleteById(id);
    }
    public Book update(Long id, Book book){
        book.setId(id);
        bookRepository.save(book);
        return book;
    }
}
