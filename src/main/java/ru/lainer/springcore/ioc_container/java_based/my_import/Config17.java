package ru.lainer.springcore.ioc_container.java_based.my_import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(Bean16.class)
public class Config17 {

  @Bean
  public Bean17 bean17() {
    return new Bean17();
  }
}
