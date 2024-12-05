package ru.lainer.springcore.bean_lifecycle.ex2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config27 {

  @Bean
  public Bean27 bean27() {
    return new Bean27();
  }

  @Bean
  public static MyBeanPostProcessor postProsBeanName() {
    return new MyBeanPostProcessor();
  }
}
