package ru.lainer.springcore.ioc_container.autowiring.by_name;

import org.springframework.beans.factory.annotation.Autowired;

public class Bean1 {

  //Здесь идет Autowired byName
  @Autowired
  private Bean2 specialNameForBean2;

  public void printInfo() {
    System.out.println("Bean1 -> printInfo()");
    specialNameForBean2.printInfo();
  }
}
