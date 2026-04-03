package dev.davisantos.library_api.repository;

import dev.davisantos.library_api.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
