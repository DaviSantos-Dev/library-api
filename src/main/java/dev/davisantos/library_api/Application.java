package dev.davisantos.library_api;

import dev.davisantos.library_api.entities.Book;
import dev.davisantos.library_api.entities.Loan;
import dev.davisantos.library_api.service.LoanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

        //Adicionando livros para testar os empréstimos
        Book book0 = new Book("O Gatilho", "Teófilo Hayashi");
        Book book1 = new Book("A Cultura do Jejum", "Luciano Subirá");
        Book book2 = new Book("Você escolherá o deserto", "Samuel whitefield");
        Book book3 = new Book("Vimos e ouvimos", "Israel Subirá");
        Book book4 = new Book("O Deus que destrói sonhos", "Rodrigo Bibo");


		SpringApplication.run(Application.class, args);
	}

}
