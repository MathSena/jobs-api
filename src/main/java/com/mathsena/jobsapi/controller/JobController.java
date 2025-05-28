package com.mathsena.jobsapi.controller;

import com.mathsena.jobsapi.model.Job;
import com.mathsena.jobsapi.services.JobService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
  @Autowired private JobService jobService;

  @PostMapping
  public ResponseEntity<Object> createJob(@Valid @RequestBody Job job) {
    try {
      var result = this.jobService.saveJob(job);
      return ResponseEntity.ok(result);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
      return ResponseEntity.status(500).body("An error occurred while creating the job");
    }
  }
}
