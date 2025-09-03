package com.mathsena.jobsapi.controller;

import com.mathsena.jobsapi.dto.AuthCompanyDTO;
import com.mathsena.jobsapi.services.AuthUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthCompanyController {

  @Autowired
  private AuthUserService authUserService;

  @PostMapping
  public String create(@RequestBody AuthCompanyDTO data) {
    return this.authUserService.execute(data);
  }

}



