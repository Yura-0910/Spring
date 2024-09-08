package ru.lainer.springcore.spel.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.spel.ex1")
public class Config22 {

  @Bean
  public Bean22 bean22() {
    return new Bean22();
  }

  @Bean
  public Bean23 bean23() {
    return new Bean23("Test1", 9);
  }
}
