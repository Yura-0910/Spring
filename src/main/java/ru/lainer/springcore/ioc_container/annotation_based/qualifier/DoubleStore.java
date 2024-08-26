package ru.lainer.springcore.ioc_container.annotation_based.qualifier;

public class DoubleStore implements Store<Double>{

  @Override
  public void info(Double aDouble) {
    System.out.println("DoubleStore: " + aDouble);
  }

}
