package ru.lainer.springsecurity.shared.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import ru.lainer.springsecurity.shared.user_details_service.UserDetailsServiceImpl;

@Component
@Profile("basicAuth")
public class FilterBasicAuth extends GenericFilterBean {

  private RequestMatcher requestMatcher;
  private UserDetailsServiceImpl userDetailsServiceImpl;

  @Autowired
  public FilterBasicAuth(UserDetailsServiceImpl userDetailsServiceImpl,
      RequestMatcher requestMatcher) {
    this.userDetailsServiceImpl = userDetailsServiceImpl;
    this.requestMatcher = requestMatcher;
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    HttpServletRequest httpServletRequest = (HttpServletRequest) request;
    if (requestMatcher.matches(httpServletRequest) && httpServletRequest.getMethod()
        .equals("GET")) {
      String loginPassword = httpServletRequest.getHeader("authorization");
      //Извлекаем логин и пароль в формате Base64, сначала миновав строку "Basic "
      loginPassword = loginPassword.substring("Basic ".length());
      //Декодируем логин и пароль в байты
      byte[] decodedBytes = Base64.getDecoder().decode(loginPassword);
      String convertByteToString = new String(decodedBytes, StandardCharsets.UTF_8);
      String[] arrayWithLoginPwd = convertByteToString.split(":");
      String loginFromRequest = arrayWithLoginPwd[0];
      userDetailsServiceImpl.loadUserByUsername(loginFromRequest);
    }
    chain.doFilter(request, response);
  }
}
