package com.mathsena.jobsapi.services;

import com.mathsena.jobsapi.model.Job;
import com.mathsena.jobsapi.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService {
  @Autowired private JobRepository jobRepository;

  public Job saveJob(Job job) {

    return jobRepository.save(job);
  }
}
