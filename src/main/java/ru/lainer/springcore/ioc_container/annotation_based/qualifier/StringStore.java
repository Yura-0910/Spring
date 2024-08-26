package ru.lainer.springcore.ioc_container.annotation_based.qualifier;

public class StringStore implements Store<String>{

  @Override
  public void info(String s) {
    System.out.println("StringStore: " + s);
  }
}
