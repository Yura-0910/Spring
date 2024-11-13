package ru.lainer.springsecurity.shared.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.lainer.springsecurity.shared.dto.SignUpDTO;
import ru.lainer.springsecurity.shared.services.ServiceJwt;
import ru.lainer.springsecurity.shared.services.ServiceSignUpJwt;

/*
 * Регистрация нового пользователя
 */
@RestController
@RequestMapping("/auth")
@Profile("profileJWT")
public class ControllerAuthJWT {

  private ServiceSignUpJwt serviceSignUpJwt;
  private final ServiceJwt serviceJwt;

  @Autowired
  public ControllerAuthJWT(ServiceSignUpJwt serviceSignUpJwt,
      ServiceJwt serviceJwt) {
    this.serviceSignUpJwt = serviceSignUpJwt;
    this.serviceJwt = serviceJwt;
  }

  @PostMapping("/signUpJWT")
  public ResponseEntity<String> signUp(@RequestBody SignUpDTO signUpDTO)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    return serviceSignUpJwt.signUp(signUpDTO);
  }

  @PostMapping("signInJWT")
  public ResponseEntity<String> signIn() {
    //получаем username, который прошел успешную аутентификацию
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();
    String username = authentication.getPrincipal().toString();
    if (username.equals("anonymousUser")) {
      return new ResponseEntity<>("anonymousUser:: Вы не прошли аутентификацию",
          HttpStatus.NOT_FOUND);
    } else {
      return new ResponseEntity<>(username + ":: Вы успешно прошли аутентификацию",
          HttpStatus.ACCEPTED);
    }
  }
}
