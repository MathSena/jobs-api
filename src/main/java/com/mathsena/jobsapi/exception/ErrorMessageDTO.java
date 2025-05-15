package com.mathsena.jobsapi.exception;

import lombok.*;

@Getter
@Setter
public class ErrorMessageDTO {

  private String message;
  private String field;

  public ErrorMessageDTO() {}

  public ErrorMessageDTO(String message, String field) {
    this.message = message;
    this.field = field;
  }
}
