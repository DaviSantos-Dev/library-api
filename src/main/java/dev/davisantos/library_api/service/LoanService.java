package dev.davisantos.library_api.service;

import dev.davisantos.library_api.entities.Book;
import dev.davisantos.library_api.entities.Loan;
import dev.davisantos.library_api.exception.BusinessException;
import dev.davisantos.library_api.exception.NotFoundException;
import dev.davisantos.library_api.repository.BookRepository;
import dev.davisantos.library_api.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;

    public Loan create(Long id){
        Book book = bookRepository.findById(id).orElseThrow(()->new NotFoundException("Book not found"));
        if(book.isAvailable() != true){
            throw new BusinessException("This book is not available");
        }
        Loan loan = new Loan(book);
        loan.startLoan();
        loan.getBook().setAvailable(false);
        return loanRepository.save(loan);
    }

    public List<Loan> findAll(){
        return loanRepository.findAll();
    }

    public Loan findById(Long id){
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new NotFoundException("Loan not found"));
        return loan;
    }

    public void returnBook(Long id){
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new NotFoundException("Loan not found"));
        if(loan.getReturnDate() != null){
            throw new BusinessException("This loan already returned");
        }
        if(loan.getBook().isAvailable() == true){
            throw new BusinessException("You can't return a available book");
        }
        loan.endLoan();
        loan.getBook().setAvailable(true);
        loanRepository.save(loan);
    }

}
    