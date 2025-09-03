package com.mathsena.jobsapi.repository;

import com.mathsena.jobsapi.model.Company;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
  Optional<Company> findByUsernameOrEmail(String username, String email);
  Company findByUsername(String username);
}
