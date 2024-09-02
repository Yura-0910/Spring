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

  //Первый способ внедрения одного бина в другой бин:: внедрение через конструктор
  @Bean
  public Bean11 bean11(Bean10 bean10){
    return new Bean11(bean10);
  }

  @Bean
  public Bean14 bean14(){
    return new Bean14();
  }

  //Второй способ внедрения одного бина в другой бин:: то же внедрение через конструктор
  @Bean
  public Bean15 bean15(){
    return new Bean15(bean14());
  }
}
