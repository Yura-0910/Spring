package ru.lainer.springcore.ioc_container.autowiring.by_name;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.autowiring.by_name")
public class ConfigByName {

  @Bean
  public Bean1 bean1() {
    return new Bean1();
  }

  @Bean(name = "specialNameForBean2")
  public Bean2 bean2() {
    return new Bean2("First");
  }

  @Bean(name = "anotherSpecialNameForBean2")
  public Bean2 beanTwo() {
    return new Bean2("Second");
  }
}
