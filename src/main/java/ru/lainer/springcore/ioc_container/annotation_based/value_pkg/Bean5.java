package ru.lainer.springcore.ioc_container.annotation_based.value_pkg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bean5 {

  @Autowired
  @Value("${property.name51}")
  private String name51;
  private String name52;

  @Autowired
  public Bean5(@Value("${property.name52:thisIsDefaultValue}") String name52) {
    this.name52 = name52;
  }

  public void printInfo() {
    System.out.println("Bean5: " + name51 + " " + name52);
  }
}
