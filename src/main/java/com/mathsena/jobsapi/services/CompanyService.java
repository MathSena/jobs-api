package com.mathsena.jobsapi.services;

import com.mathsena.jobsapi.model.Company;
import com.mathsena.jobsapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

  @Autowired private CompanyRepository companyRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  public Company saveCompany(Company company) {
    this.companyRepository
        .findByUsernameOrEmail(company.getUsername(), company.getEmail())
        .ifPresent(
            existingCompany -> {
              throw new IllegalArgumentException("Company with username or email already exists");
            });

    var password = passwordEncoder.encode(company.getPassword());
    company.setPassword(password);
    return companyRepository.save(company);
  }
}
