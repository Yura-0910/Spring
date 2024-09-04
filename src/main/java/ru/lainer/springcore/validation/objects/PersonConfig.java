package ru.lainer.springcore.validation.objects;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.SimpleErrors;

@Configuration
@ComponentScan("ru.lainer.springcore.validation.objects")
public class PersonConfig {

  @Bean
  public PersonValidator personValidator() {
    return new PersonValidator();
  }

  @Bean
  public Person person() {
    return new Person("", -1);
  }

  @Bean
  public SimpleErrors simpleErrors() {
    return new SimpleErrors(person(), "ObjectNameIsPerson");
  }
}
