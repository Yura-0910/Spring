package ru.lainer.springcore.aop.ex1;

public class Bean26 {

  public void printInfo() {
    System.out.println("Bean26 ->printInfo()");
  }

  public int printInfo2() {
    int result = 13;
    return result;
  }

  public void throwAnException() {
    throw new NullPointerException("Bean26 ->throwAnException():: выброшено исключение");
  }

  public int forAround() {
    int result = 9;
    System.out.println("Bean26 -> метод forAround()");
    return result;
    //return result/0; //Для случая, когда метод должен генерировать исключение
  }
}
