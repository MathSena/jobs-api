package com.mathsena.jobsapi.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@Log4j2
public class ExceptionHandlerController {

  private MessageSource messageSource;

  public ExceptionHandlerController(MessageSource messageSource) {
    this.messageSource = messageSource;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<List<ErrorMessageDTO>> handleException(MethodArgumentNotValidException e) {
    List<ErrorMessageDTO> dto = new ArrayList<>();

    e.getBindingResult()
        .getFieldErrors()
        .forEach(
            err -> {
              String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
              ErrorMessageDTO errorMessageDTO = new ErrorMessageDTO(message, err.getField());
              dto.add(errorMessageDTO);
            });

    return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
  }
}
