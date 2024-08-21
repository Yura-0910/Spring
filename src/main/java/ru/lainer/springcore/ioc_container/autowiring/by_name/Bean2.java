package ru.lainer.springcore.ioc_container.autowiring.by_name;

public class Bean2 {
  private String data;

  public Bean2(String data) {
    this.data = data;
  }

  public void printInfo() {
    System.out.println("Bean2 -> printInfo() -> " + data);
  }
}
