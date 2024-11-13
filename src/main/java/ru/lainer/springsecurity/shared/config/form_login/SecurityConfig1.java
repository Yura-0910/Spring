package ru.lainer.springsecurity.shared.config.form_login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/*
 Дефолтный "formLogin" + временный пароль, генерирующийся автоматически, при запуске приложения
 Дефолтный логин: user
 */
@Configuration
@EnableWebSecurity(debug = true)
@Profile("formLoginDefault")
public class SecurityConfig1 {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        //Для любого пользователя прошедшего аутентификацию:: доступен любой URL (это авторизация)
        .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
        //Просто включаем дефолтный "formLogin" на URL = http://localhost:8080/login
        .formLogin(Customizer.withDefaults())
        /*
         Второй способ включения дефолтного "formLogin" + еще задаем "EndPoints",
         которые срабатывают при успешной и не успешной авторизации
         */
        .formLogin(form -> form
            .defaultSuccessUrl("/success")
            .failureUrl("/error")
            //URL = success и URL = error:: будут доступны любому пользователю без аутентификации
            .permitAll());
    return http.build();
  }
}
