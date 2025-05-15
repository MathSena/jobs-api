package com.mathsena.jobsapi.services;

import com.mathsena.jobsapi.exception.UserFoundException;
import com.mathsena.jobsapi.model.Candidate;
import com.mathsena.jobsapi.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

  @Autowired private CandidateRepository candidateRepository;

  public Candidate createCandidate(Candidate candidate) {
    this.candidateRepository
        .findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail())
        .ifPresent(
            c -> {
              throw new UserFoundException();
            });
    return this.candidateRepository.save(candidate);
  }
}
