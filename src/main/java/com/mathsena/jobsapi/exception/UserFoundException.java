package com.mathsena.jobsapi.exception;

public class UserFoundException extends RuntimeException {
  public UserFoundException() {
    super("User already exists");
  }
}
