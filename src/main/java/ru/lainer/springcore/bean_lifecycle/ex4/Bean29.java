package ru.lainer.springcore.bean_lifecycle.ex4;

public class Bean29 {

  public void myOwnInit() {
    System.out.println("Bean29 -> логика инициализации Bean29");
  }

  public void myOwnDestroy() {
    System.out.println("Bean29 -> логика разрушения Bean29");
  }

  public void printInfo() {
    System.out.println("Bean29 -> printInfo");
  }
}
