package ru.lainer.springcore.spel.ex2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.spel.ex2")
public class Config24 {

  @Bean
  public Bean24 bean24() {
    return new Bean24();
  }
}
