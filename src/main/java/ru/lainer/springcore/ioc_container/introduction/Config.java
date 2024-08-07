package ru.lainer.springcore.ioc_container.introduction;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.introduction")
public class Config {

  @Bean
  public StudentIdCard studentIdCard() {
    return new StudentIdCard("Yura", "Applied Mathematics");
  }
}
