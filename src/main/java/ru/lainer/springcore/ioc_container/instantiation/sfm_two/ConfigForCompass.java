package ru.lainer.springcore.ioc_container.instantiation.sfm_two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.instantiation.sfm_two")
public class ConfigForCompass {
 @Bean
  public Compass compass() {
  //Instantiation с помощью "Static Factory Method"
   return Compass.bayCompass();
 }
}
