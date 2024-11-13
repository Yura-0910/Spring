package ru.lainer.springsecurity.shared.config.basic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ru.lainer.springsecurity.shared.filters.FilterAuthBasic;

/**
 * Config для "Basic Authentication"
 */
@Configuration
@EnableWebSecurity(debug = true)
@Profile("basicAuth")
public class SecurityConfig5 {
  private FilterAuthBasic filterAuthBasic;

  @Autowired
  public SecurityConfig5(FilterAuthBasic filterAuthBasic) {
    this.filterAuthBasic = filterAuthBasic;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .addFilterBefore(filterAuthBasic, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
