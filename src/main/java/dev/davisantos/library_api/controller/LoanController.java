package dev.davisantos.library_api.controller;

import dev.davisantos.library_api.dto.BookDto;
import dev.davisantos.library_api.entities.Loan;
import dev.davisantos.library_api.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/{id}")
    public ResponseEntity<Loan> create(@PathVariable ("id") Long id){
        Loan loan = loanService.create(id);
        return ResponseEntity.ok().body(loan);
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAll(){
        return ResponseEntity.ok().body(loanService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> findById(@PathVariable ("id") Long id){
        return ResponseEntity.ok().body(loanService.findById(id));
    }
    @PutMapping("/{loanId}")
    public ResponseEntity<String> returnBook(@PathVariable ("loanId") Long loan){
        loanService.returnBook(loan);
        return ResponseEntity.ok().body("The book has been returned");
    }
}
