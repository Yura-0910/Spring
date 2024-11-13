package ru.lainer.springsecurity.shared.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lainer.springsecurity.shared.dto.SignUpDTO;
import ru.lainer.springsecurity.shared.services.ServiceSignUp;

/**
 * Регистрация нового пользователя
 */
@RestController
@RequestMapping("/api")
@Profile("loginPasswordInDataBase")
public class ControllerSignUp {

  private final ServiceSignUp serviceSignUp;

  @Autowired
  public ControllerSignUp(ServiceSignUp serviceSignUp) {
    this.serviceSignUp = serviceSignUp;
  }

  @PostMapping("/signup")
  public ResponseEntity<String> signUp(@RequestBody SignUpDTO signUpDTO) {
    return serviceSignUp.registerNewUser(signUpDTO);
  }
}
