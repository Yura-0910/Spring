package ru.lainer.springcore.bean_lifecycle.ex3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config28 {

  @Bean
  public MyInitializingBean myInitializingBean() {
    return new MyInitializingBean();
  }

}
