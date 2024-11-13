package ru.lainer.springsecurity.shared.config.form_login;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.lainer.springsecurity.shared.filters.Filter1;
import ru.lainer.springsecurity.shared.filters.Filter2;

/**
 * Config для использования разных фильтров, например Filter1 и Filter2. Пароль генерируется
 * автоматически при запуске приложения.
 */
@Configuration
@EnableWebSecurity(debug = true)
@Profile("difFilters")
public class SecurityConfig0 {

  @Bean
  public Filter1 filter1() {
    return new Filter1();
  }

  @Bean
  public Filter2 filter2() {
    return new Filter2();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(authorize -> authorize
            .requestMatchers(new AntPathRequestMatcher("/api/getUser")).permitAll()
            .anyRequest().authenticated())
        //Сначала сработает Filter1, затем Filter2, потом AuthorizationFilter
        .addFilterBefore(filter1(), AuthorizationFilter.class)
        //Если создать @Bean=Filter2, то он будет вызываться два раза за запрос, лучше "new Filter2"
        .addFilterBefore(filter2(), AuthorizationFilter.class);
    return http.build();
  }
}
