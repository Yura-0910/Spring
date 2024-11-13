package ru.lainer.springsecurity.shared.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

/*
 OncePerRequestFilter вызывается при каждом запросе, но только один раз,
 а реализация интерфейса "Filter" - может два раза вызываться за запрос
 */
public class Filter1 extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    /*
     - "authentication" храниться в "SecurityContext"
     - "SecurityContext" хранится в "SecurityContextHolder"
     */
    SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
    /*
     Можно использовать любую реализацию Authentication, например TestingAuthenticationToken,
     который предназначен вообще-то для использования в unit-тестах.
     */
    Authentication authentication = new TestingAuthenticationToken("username",
        "password", "ROLE_USER");
    securityContext.setAuthentication(authentication);
    SecurityContextHolder.setContext(securityContext);
    System.out.println("Filter1 сработал");

    //вызываем остальные фильтры в цепочке.
    filterChain.doFilter(request, response);
  }
}
