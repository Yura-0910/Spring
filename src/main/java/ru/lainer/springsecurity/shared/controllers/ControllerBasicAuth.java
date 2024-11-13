package ru.lainer.springsecurity.shared.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Profile("basicAuth")
public class ControllerBasicAuth {

  @GetMapping("/basicAuth")
  public String basicAuth() {
    return "Аутентификация прошла успешно. Доступ к этому ресурсу:: разрешен";
  }
}
