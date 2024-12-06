package ru.lainer.springcore.bean_lifecycle.destroy.ex5;

import org.springframework.beans.factory.DisposableBean;

public class MyDisposableBean implements DisposableBean {

  public void print() {
    System.out.println("MyDisposableBean -> print()");
  }

  @Override
  public void destroy() throws Exception {
    System.out.println("MyDisposableBean:: освобождаем ресурсы");
  }
}
