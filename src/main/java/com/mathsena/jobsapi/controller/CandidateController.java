package com.mathsena.jobsapi.controller;

import com.mathsena.jobsapi.model.Candidate;
import com.mathsena.jobsapi.services.CandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidates")
public class CandidateController {

  @Autowired private CandidateService candidateService;

  @PostMapping("/")
  public ResponseEntity<Object> createCandidate(@Valid @RequestBody Candidate candidate) {
    try {
      var result = candidateService.createCandidate(candidate);
      return ResponseEntity.ok(result);

    } catch (Exception e) {
      // Handle the exception as needed
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
