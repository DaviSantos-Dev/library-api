package dev.davisantos.library_api;

import dev.davisantos.library_api.entities.Book;
import dev.davisantos.library_api.entities.Loan;
import dev.davisantos.library_api.repository.BookRepository;
import dev.davisantos.library_api.service.BookService;
import dev.davisantos.library_api.service.LoanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

    }

}
