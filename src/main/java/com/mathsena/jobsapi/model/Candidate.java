package com.mathsena.jobsapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@Entity(name = "candidate")
public class Candidate {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column private String name;
  private String username;

  @Email(message = "Email should be valid")
  private String email;

  @Length(min = 6, message = "Password should be at least 6 characters")
  private String password;

  private String resume;
  private String description;
  @CreationTimestamp private LocalDateTime createdAt;
}
