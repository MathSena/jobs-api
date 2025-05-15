package com.mathsena.jobsapi.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity(name = "job")
public class Job {

  @Id
  @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
  private Long id;

  private String title;
  private String description;
  private String level;
  private String location;

  @ManyToOne
  @JoinColumn(name = "company_id")
  private Company company;

  @Column(name = "company_id")
  private Long companyId;

  @CreationTimestamp private LocalDateTime createdAt;
}
