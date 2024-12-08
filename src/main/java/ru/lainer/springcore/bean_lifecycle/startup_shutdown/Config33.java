package ru.lainer.springcore.bean_lifecycle.startup_shutdown;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config33 {

  @Bean
  public MySmartLifecycle mySmartLifecycle(){
    return new MySmartLifecycle ();
  }
}
