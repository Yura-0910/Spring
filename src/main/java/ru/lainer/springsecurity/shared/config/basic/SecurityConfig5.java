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
import ru.lainer.springsecurity.shared.filters.FilterBasicAuth;

/**
 * Config для "Basic Authentication"
 */
@Configuration
@EnableWebSecurity(debug = true)
@Profile("basicAuth")
public class SecurityConfig5 {
  private FilterBasicAuth filterBasicAuth;

  @Autowired
  public SecurityConfig5(FilterBasicAuth filterBasicAuth) {
    this.filterBasicAuth = filterBasicAuth;
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .anyRequest().authenticated())
        .httpBasic(Customizer.withDefaults())
        .addFilterBefore(filterBasicAuth, UsernamePasswordAuthenticationFilter.class);
    return http.build();
  }
}
