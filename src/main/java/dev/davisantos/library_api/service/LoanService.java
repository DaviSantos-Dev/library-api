package dev.davisantos.library_api.service;

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

    public void create(Loan loan, Long id){
        if(loan.getBook().getAvailable() != true){
            throw new BusinessException("This book is not available");
        }
        if(loan.getBook() == null){
            throw new BusinessException("You have to choice a book to loan");
        }
        loan.setBook(bookRepository.findById(id).get());
        loan.setLoanDate();
        loan.getBook().setAvailable(false);
        loanRepository.save(loan);
    }

    public List<Loan> findAll(){
        return loanRepository.findAll();
    }

    public Loan findById(Long id){
        Loan loan = loanRepository.findById(id).get();
        if(loan == null){
            throw new NotFoundException("Loan not found");
        }
        return loan;
    }

    public void returnBook(Long id){
        Loan loan = loanRepository.findById(id).get();
        if(loan == null){
            throw new NotFoundException("Loan Not Found");
        }
        if(loan.getReturnDate() != null){
            throw new BusinessException("This loan already returned");
        }
        if(loan.getBook().getAvailable() == true){
            throw new BusinessException("You can't return a available book");
        }
        loan.setReturnDate();
        loan.getBook().setAvailable(true);
        loanRepository.save(loan);
    }

}
    