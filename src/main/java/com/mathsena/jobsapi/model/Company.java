package com.mathsena.jobsapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
@Entity(name = "company")
public class Company {

  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String cnpj;

  @Email(message = "Email should be valid")
  private String email;

  @Length(min = 6, message = "Password should be at least 6 characters")
  private String password;

  private String username;
  private String description;
  private String location;

  @CreationTimestamp private LocalDateTime createdAt;
}
