package ru.lainer.springsecurity.shared.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lainer.springsecurity.shared.dto.SignUpDTO;
import ru.lainer.springsecurity.shared.services.ServiceSignUpFormLogin;

@RestController
@RequestMapping("/api")
@Profile("loginPasswordInDataBase")
public class ControllerAuthFormLogin {

  private final ServiceSignUpFormLogin serviceSignUpFormLogin;

  @Autowired
  public ControllerAuthFormLogin(ServiceSignUpFormLogin serviceSignUpFormLogin) {
    this.serviceSignUpFormLogin = serviceSignUpFormLogin;
  }

  /**
   * Регистрация нового пользователя
   */
  @PostMapping("/signup")
  public ResponseEntity<String> signUp(@RequestBody SignUpDTO signUpDTO) {
    return serviceSignUpFormLogin.registerNewUser(signUpDTO);
  }
}
