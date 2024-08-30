package ru.lainer.springcore.ioc_container.java_based.declaring_bean;

import org.springframework.context.annotation.Bean;

public interface InterfaceWithBean {

  @Bean
  public default Bean9 bean9(){
    return new Bean9();
  }
 }
