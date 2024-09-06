package ru.lainer.springcore.validation.bean;

import jakarta.validation.Valid;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.annotation.Validated;

@Configuration
@ComponentScan("ru.lainer.springcore.validation.bean")
@Validated
@EnableAspectJAutoProxy
public class Config18 {

  @Bean
  public Bean18 bean18() {
    return new Bean18("1", -3);
  }

  @Bean
  public Bean19 bean19(@Valid Bean18 bean18) {
    return new Bean19(bean18);
  }
}
