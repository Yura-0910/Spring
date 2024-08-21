package ru.lainer.springcore.ioc_container.autowiring.by_type;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.autowiring.by_type")
public class ConfigByType {

  @Bean(name = "Bean3QuniqueName")
  public Bean3 bean3FunctionName(){
    return new Bean3();
  }

  @Bean(name = "Bean4QuniqueName")
  public Bean4 bean4FunctionName(){
    return new Bean4();
  }
}
