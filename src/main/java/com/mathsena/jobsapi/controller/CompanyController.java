package com.mathsena.jobsapi.controller;

import com.mathsena.jobsapi.model.Company;
import com.mathsena.jobsapi.services.CompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

  @Autowired private CompanyService companyService;

  // In the controller
  @PostMapping
  public ResponseEntity<Object> createCompany(@Valid @RequestBody Company company) {
    try {
      var result = this.companyService.saveCompany(company);
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(500).body("An error occurred while creating the company");
    }
  }
}
