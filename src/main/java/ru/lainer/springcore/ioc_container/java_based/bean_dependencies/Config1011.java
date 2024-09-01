package ru.lainer.springcore.ioc_container.java_based.bean_dependencies;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.java_based.bean_dependencies")
public class Config1011 {

  @Bean
  public Bean10 bean10(){
    return new Bean10();
  }

  @Bean
  public Bean11 bean11(Bean10 bean10){
    return new Bean11(bean10);
  }
}
