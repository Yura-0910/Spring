package ru.lainer.springcore.bean_lifecycle.destroy.ex6;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config31 {

  @Bean
  public Bean31 bean31() {
    return new Bean31();
  }
}
