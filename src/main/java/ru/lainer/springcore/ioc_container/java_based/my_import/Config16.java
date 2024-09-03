package ru.lainer.springcore.ioc_container.java_based.my_import;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config16 {

  @Bean
  public Bean16 bean16() {
    return new Bean16();
  }

}
