package ru.lainer.springcore.ioc_container.java_based.bean_dependencies;

public class Bean15 {

  private Bean14 bean14;

  public Bean15(Bean14 bean14) {
    this.bean14 = bean14;
  }

  public void printInfo() {
    bean14.printInfo();
    System.out.println("Bean15 -> printInfo()");
  }
}
