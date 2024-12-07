package ru.lainer.springcore.bean_lifecycle.destroy.ex7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config32 {

  @Bean(destroyMethod = "myOwnDestroy")
  public Bean32 bean32() {
    return new Bean32();
  }
}
