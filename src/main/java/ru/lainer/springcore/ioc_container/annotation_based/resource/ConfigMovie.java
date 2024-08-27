package ru.lainer.springcore.ioc_container.annotation_based.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.annotation_based.resource")
public class ConfigMovie {

  @Bean
  public MovieFinder movieFinder() {
    return new MovieFinder();
  }

}
