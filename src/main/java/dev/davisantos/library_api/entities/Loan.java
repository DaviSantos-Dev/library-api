package dev.davisantos.library_api.entities;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Book book;
    private Instant loanDate;
    @Column (nullable = true)
    private Instant returnDate;


    public Loan(){
    }
    public Loan(Book book){
        this.book = book;
        loanDate = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Instant getLoanDate() {
        return loanDate;
    }

    public Instant getReturnDate() {
        return returnDate;
    }

    public void startLoan(){
        this.loanDate = Instant.now();
    }
    public void endLoan(){
        this.returnDate = Instant.now();
    }
}
