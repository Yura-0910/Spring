package ru.lainer.springsecurity.shared.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerFormLogin {
  //Данный EndPoint и возвращает FormLogin
  @GetMapping("/login")
  public String get() {
    return "login";
  }

  //Возвращает страничку, в случае успешной аутентификации
  @GetMapping("/success")
  public String success() {
    return "success";
  }

  //Возвращает страничку в случае не успешной аутентификации
  @GetMapping("/error")
  public String error(){
    return "error";
  }
}
