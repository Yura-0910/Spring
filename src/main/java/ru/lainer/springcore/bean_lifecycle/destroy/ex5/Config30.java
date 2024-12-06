package ru.lainer.springcore.bean_lifecycle.destroy.ex5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config30 {

  @Bean
  public MyDisposableBean myDisposableBean() {
    return new MyDisposableBean();
  }
}
