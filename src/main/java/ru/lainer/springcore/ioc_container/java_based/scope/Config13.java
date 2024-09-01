package ru.lainer.springcore.ioc_container.java_based.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.java_based.scope")
public class Config13 {

  @Bean
  @Scope("prototype")
  public Bean13 bean13() {
    return new Bean13();
  }
}
