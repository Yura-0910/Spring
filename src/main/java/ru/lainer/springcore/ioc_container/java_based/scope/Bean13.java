package ru.lainer.springcore.ioc_container.java_based.scope;

public class Bean13 {

  private static int count;

  public void increaseCount() {
    count++;
    System.out.println("count = " + count);
  }

}
