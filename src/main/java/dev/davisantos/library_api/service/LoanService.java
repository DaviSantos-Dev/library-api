package dev.davisantos.library_api.service;

import dev.davisantos.library_api.entities.Loan;
import dev.davisantos.library_api.exception.BusinessException;
import dev.davisantos.library_api.exception.NotFoundException;
import dev.davisantos.library_api.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public void create(Loan loan){
        if(loan.getBook().getAvailable() != true){
            throw new BusinessException("This book is not available");
        }
        if(loan.getBook() == null){
            throw new BusinessException("You have to choice a book to loan");
        }
        loan.setLoanDate();
        loan.getBook().setAvailable(false);
        loanRepository.save(loan);
    }

    public List<Loan> findAll(){
        return loanRepository.findAll();
    }

    public Optional<Loan> findById(Long id){
        return loanRepository.findById(id);
    }

    //Optei por deixar sem update no Loan
    //Pois achei sem sentido alterar um emprétismo, visto que o comum seria devolver o livro emprestado e pegar outro

    public void delete(Long id){
        loanRepository.deleteById(id);
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
    }

}
    