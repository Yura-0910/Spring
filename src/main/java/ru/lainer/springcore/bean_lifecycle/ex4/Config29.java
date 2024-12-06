package ru.lainer.springcore.bean_lifecycle.ex4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config29 {

  @Bean(initMethod = "myOwnInit", destroyMethod = "myOwnDestroy")
  public Bean29 bean29(){
    return new Bean29();
  }

}
