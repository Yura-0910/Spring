package ru.lainer.springcore.spel.ex1;

public class Bean23 {

  public String field1;
  public int field2;

  public Bean23(String field1, int field2) {
    this.field1 = field1;
    this.field2 = field2;
  }

  public void printInfo() {
    System.out.println("Bean23: " + field1 + " " + field2);
  }
}
