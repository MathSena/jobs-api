package com.mathsena.jobsapi.repository;

import com.mathsena.jobsapi.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
  Optional<Candidate> findByUsernameOrEmail(String username, String email);
}
