package ru.lainer.springsecurity.shared.config.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * Config для "Basic Authentication". Второй конфиг - чтоб не было циклической зависимости
 */
@Configuration
@EnableWebSecurity(debug = true)
@Profile("basicAuth")
public class SecurityConfig5Addition {

  @Bean
  public RequestMatcher requestMatcher() {
    return new AntPathRequestMatcher("/api/basicAuth");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
