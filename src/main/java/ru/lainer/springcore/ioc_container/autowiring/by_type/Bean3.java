package ru.lainer.springcore.ioc_container.autowiring.by_type;

import org.springframework.beans.factory.annotation.Autowired;

public class Bean3 {

  //Здесь идет Autowired byType
  @Autowired
  private Bean4 bean4;

  public void printInfo() {
    System.out.println("Bean3 -> printInfo()");
    bean4.printInfo();
  }
}
