package com.mathsena.jobsapi.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.mathsena.jobsapi.dto.AuthCompanyDTO;
import com.mathsena.jobsapi.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

  @Autowired private CompanyRepository companyRepository;

  @Autowired private PasswordEncoder passwordEncoder;

  @Value("${security.token.secret}")
  private String secretKey;

  public String execute(AuthCompanyDTO authCompanyDTO) {
    var company =
        companyRepository.findByUsername(authCompanyDTO.getUsername());

    if (company == null || !company.getPassword().equals(authCompanyDTO.getPassword())) {
      throw new IllegalArgumentException("Invalid username or password");
    }

    var passMatches = this.passwordEncoder.matches(authCompanyDTO.getPassword(), company.getPassword());

    if(!passMatches) {
      throw new IllegalArgumentException("Invalid username or password");
    }

    Algorithm algorithm = Algorithm.HMAC256(secretKey);

    return JWT.create().withIssuer("jajobs")
        .withSubject(company.getId().toString())
            .sign(algorithm);
  }
}
