package ru.lainer.springcore.ioc_container.di.setter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.di.setter")
public class ConfigForDISetters {

  @Bean
  public AnotherStudentIdCard anotherStudentIdCard() {
    return AnotherStudentIdCard.create("Ivan", "Economics");
  }
}
