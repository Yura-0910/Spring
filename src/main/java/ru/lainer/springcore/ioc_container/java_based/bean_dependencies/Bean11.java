package ru.lainer.springcore.ioc_container.java_based.bean_dependencies;

public class Bean11 {
  public Bean10 bean10;

  public Bean11(Bean10 bean10) {
    this.bean10 = bean10;
  }
  public void printInfo() {
    bean10.printInfo();
    System.out.println("Bean11 -> printInfo()");
  }
}
