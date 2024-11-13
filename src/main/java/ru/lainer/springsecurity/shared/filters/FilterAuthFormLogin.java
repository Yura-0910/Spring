package ru.lainer.springsecurity.shared.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.lainer.springsecurity.shared.user_details_service.UserDetailsServiceImpl;

/**
 * Фильтр производит аутентификацию
 */
@Component
@Profile("loginPasswordInDataBase")
public class FilterAuthFormLogin extends GenericFilterBean {

  private UserDetailsServiceImpl userDetailsServiceImpl;
  private RequestMatcher customFilterUrl;

  @Autowired
  public FilterAuthFormLogin(UserDetailsServiceImpl userDetailsServiceImpl,
      RequestMatcher customFilterUrl) {
    this.userDetailsServiceImpl = userDetailsServiceImpl;
    this.customFilterUrl = customFilterUrl;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;

    //Если URL = /login и метод POST, то извлекаем из запроса username
    if (customFilterUrl.matches(httpServletRequest) && httpServletRequest.getMethod()
        .equals("POST")) {
      //Тут начинается аутентификация
      userDetailsServiceImpl.loadUserByUsername(httpServletRequest.getParameter("username"));
    }
    chain.doFilter(request, response);
  }
}
