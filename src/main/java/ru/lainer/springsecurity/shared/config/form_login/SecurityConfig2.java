package ru.lainer.springsecurity.shared.config.form_login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
 Пользовательский "formLogin" + временный пароль, генерирующийся автоматически, при запуске
 приложения
 Дефолтный логин: user
 */
@Configuration
@EnableWebSecurity(debug = true)
@Profile("formLoginCustom")
public class SecurityConfig2 {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
        //Включаем пользовательский "formLogin" на URL = "/login"
        .formLogin(form -> form
            .loginPage("/login") //Если это закомментировать, то будет дефолтный "formLogin"
            .defaultSuccessUrl("/success")
            .failureUrl("/error")
            .permitAll());
    return http.build();
  }
}
