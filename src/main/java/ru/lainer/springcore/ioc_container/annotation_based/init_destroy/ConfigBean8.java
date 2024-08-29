package ru.lainer.springcore.ioc_container.annotation_based.init_destroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.annotation_based.init_destroy")
public class ConfigBean8 {

  @Bean(initMethod = "myOwnInit")
  @Primary
  public Bean8 create(){
    return new Bean8();
  }

  @Bean(destroyMethod = "myOwnDestroy")
  public Bean8 destroy(){
    return new Bean8();
  }
}
