package ru.lainer.springcore.ioc_container.annotation_based.init_destroy;

public class Bean8 {

  public void myOwnInit() {
    System.out.println("Bean8 -> логика инициализации Bean8");
  }

  public void myOwnDestroy() {
    System.out.println("Bean8 -> логика разрушения Bean8");
  }

  public void printInfo() {
    System.out.println("Bean8 -> printInfo");
  }
}
