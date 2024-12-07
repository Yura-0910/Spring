package ru.lainer.springcore.bean_lifecycle.destroy.ex7;

public class Bean32 {

  public void myOwnDestroy() {
    System.out.println("Bean32 -> логика разрушения Bean32");
  }

  public void printInfo() {
    System.out.println("Bean32 -> print()");
  }
}
