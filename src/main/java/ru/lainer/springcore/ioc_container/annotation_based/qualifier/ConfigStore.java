package ru.lainer.springcore.ioc_container.annotation_based.qualifier;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.annotation_based.qualifier")
public class ConfigStore {
  @Bean
  public StringStore stringStore() {
    return new StringStore();
  }

  @Bean
  public IntegerStore integerStore() {
    return new IntegerStore();
  }

  @Bean
  public DoubleStore doubleStore1() {
    return new DoubleStore();
  }

  @Bean
  public DoubleStore doubleStore2() {
    return new DoubleStore();
  }
}
