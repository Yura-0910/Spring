package ru.lainer.springsecurity.shared.controllers;

import java.util.Collection;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
 * Извлечение логина\пароля\ролей из SecurityContextHolder
 */
@RestController
@RequestMapping("/api")
@Profile("difFilters")
public class ControllerGetUser {

  @GetMapping("/getUser")
  public String getUser() {
    String result = "";
    /*
     SecurityContextHolder доступен всем в рамках одного потока и его не надо внедрять.

     SecurityContext всегда будет != null, так как сохранение логина\пароля в SecurityContextHolder,
     минуя этап аутентификации:: происходит в Filter1, а этот фильтр(Filter1) срабатывает
     при каждом запросе и все фильтры завершают свою работу до того, как начнет выполняться тело
     данного метода "getUser()"
     */
    SecurityContext context = SecurityContextHolder.getContext();
    Authentication authentication = context.getAuthentication();

    String username = authentication.getPrincipal().toString();
    result = result + username + " ";

    String password = authentication.getCredentials().toString();
    result = result + password + " ";

    Collection<? extends GrantedAuthority> roles = authentication.getAuthorities();
    for (GrantedAuthority role : roles) {
      result = result + role.getAuthority() + " ";
    }
    System.out.println("Сработал ControllerGetUser:: " + result);
    return result;
  }
}
