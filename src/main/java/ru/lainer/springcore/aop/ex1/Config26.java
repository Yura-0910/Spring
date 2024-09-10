package ru.lainer.springcore.aop.ex1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.lainer.springcore.aop.ex1")
@EnableAspectJAutoProxy //включает использование Spring AOP Proxy
public class Config26 {

  @Bean
  public Bean26 bean26() {
    return new Bean26();
  }
}
