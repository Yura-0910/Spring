package ru.lainer.springcore.ioc_container.annotation_based.postconstruct_predestroy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bean7 {

  private Bean6 bean6;

  @Autowired
  public Bean7(Bean6 bean6) {
    this.bean6 = bean6;
  }

  public void printInfo() {
    System.out.println("Bean7 -> printInfo()");
    bean6.printInfo();
  }

  @PostConstruct
  public void postConstruct() {
    System.out.println("Bean7 -> postConstruct():: после создания Bean7");
  }

  @PreDestroy
  public void preDestroy() {
    System.out.println("Bean7 -> preDestroy():: перед удалением Bean7");
  }
}
