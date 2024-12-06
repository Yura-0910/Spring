package ru.lainer.springcore.bean_lifecycle.destroy.ex6;

import jakarta.annotation.PreDestroy;

public class Bean31 {

  public void print() {
    System.out.println("Bean31 -> print()");
  }

  @PreDestroy
  private void preDestroy() {
    System.out.println("Bean31:: освобождаем ресурсы");
  }
}
