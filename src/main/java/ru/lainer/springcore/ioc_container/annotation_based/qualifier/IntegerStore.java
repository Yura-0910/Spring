package ru.lainer.springcore.ioc_container.annotation_based.qualifier;

public class IntegerStore implements Store<Integer>{

  @Override
  public void info(Integer integer) {
    System.out.println("IntegerStore: " + integer);
  }
}
