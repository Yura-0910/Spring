package ru.lainer.springcore.ioc_container.annotation_based.postconstruct_predestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.annotation_based.postconstruct_predestroy")
public class ConfigBean6 {

  @Bean
  public Bean6 bean6() {
    return new Bean6();
  }
}
