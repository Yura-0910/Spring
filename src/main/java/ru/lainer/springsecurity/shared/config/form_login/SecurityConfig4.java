package ru.lainer.springsecurity.shared.config.form_login;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.web.util.matcher.RequestMatcher;
import ru.lainer.springsecurity.shared.filters.FilterAuthFormLogin;
import ru.lainer.springsecurity.shared.user_details_service.UserDetailsServiceImpl;

/*
 Пользовательский "formLogin".
 Логин и пароль хранятся в Базе Данных
 */
@Configuration
@EnableWebSecurity(debug = true)
@Profile("loginPasswordInDataBase")
public class SecurityConfig4 {

  private UserDetailsServiceImpl userDetailsServiceImpl;

  @Autowired
  public SecurityConfig4(UserDetailsServiceImpl userDetailsServiceImpl) {
       this.userDetailsServiceImpl = userDetailsServiceImpl;
  }

  @Bean
  public RequestMatcher requestMatcher() {
    return new AntPathRequestMatcher("/login");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public FilterAuthFormLogin filterSignIn() {
    return new FilterAuthFormLogin(userDetailsServiceImpl, requestMatcher());
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(new AntPathRequestMatcher("/h2-console/**")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/api/signup")).permitAll()
            .anyRequest().authenticated())
        .formLogin(form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/success")
            .failureUrl("/error")
            .permitAll())
        .addFilterBefore(filterSignIn(), UsernamePasswordAuthenticationFilter.class);
    //Для доступа к H2-Console
    http.csrf(csrf -> csrf.disable());
    http.headers(h -> h.frameOptions(f -> f.disable()));
    return http.build();
  }
}
