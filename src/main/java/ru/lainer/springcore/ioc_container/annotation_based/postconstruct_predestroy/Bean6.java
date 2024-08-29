package ru.lainer.springcore.ioc_container.annotation_based.postconstruct_predestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class Bean6 {
  public void printInfo() {
    System.out.println("Bean6 -> printInfo()");
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("Bean6 -> postConstruct():: после создания Bean6");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("Bean6 -> preDestroy():: перед удалением Bean6");
  }
}
