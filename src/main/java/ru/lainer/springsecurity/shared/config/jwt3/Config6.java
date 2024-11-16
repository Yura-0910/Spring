package ru.lainer.springsecurity.shared.config.jwt3;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.lainer.springsecurity.shared.filters.FilterAuthJWT;

/**
 * Config для "JWT Authentication"
 */
@Configuration
@EnableWebSecurity(debug = true)
@Profile("profileJWT")
@RequiredArgsConstructor
public class Config6 {

  private final FilterAuthJWT FilterAuthJWT;

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/auth/**")).permitAll()
            .anyRequest().authenticated())
        .addFilterBefore(FilterAuthJWT, UsernamePasswordAuthenticationFilter.class);
    //Для доступа к H2-Console
    http.csrf(csrf -> csrf.disable());
    http.headers(h -> h.frameOptions(f -> f.disable()));
    return http.build();
  }
}
