package com.mathsena.jobsapi.repository;

import com.mathsena.jobsapi.model.Job;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

  Optional<Object> findByTitle(String title);
}
