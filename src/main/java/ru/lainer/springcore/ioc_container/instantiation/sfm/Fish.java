package ru.lainer.springcore.ioc_container.instantiation.sfm;

public class Fish {
  String name;
  String family;

  private Fish(String name, String family) {
    this.name = name;
    this.family = family;
  }

  //Static Factory Method: каждый раз возвращает новый объект
  public static Fish add(String name, String family) {
    return new Fish(name, family);
  }

  //Static Factory Method: каждый раз возвращает новый объект
  public static Fish addAnotherOne(String name, String family) {
    return new Fish(name, family);
  }

  @Override
  public String toString() {
    return "Fish{" +
        "name='" + name + '\'' +
        ", family='" + family + '\'' +
        '}';
  }
}
