package ru.lainer.springcore.validation.bean;

public class Bean19 {

  private Bean18 bean18;

  public Bean19(Bean18 bean18) {
    this.bean18 = bean18;
  }

  public void printInfo() {
    System.out.println("Bean18 -> " + bean18.getName() + " " + bean18.getAge());
    System.out.println("Bean19 -> printInfo()");
  }
}
