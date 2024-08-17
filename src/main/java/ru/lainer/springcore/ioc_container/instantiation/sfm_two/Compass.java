package ru.lainer.springcore.ioc_container.instantiation.sfm_two;

public class Compass {

  private String name;
  //Всегда будет name = "MosCompass"
  private static Compass compass = new Compass("MosCompass");

  private Compass(String name) {
    this.name = name;
  }

  //Static Factory Method: каждый раз возвращает один и тот же объект
  public static Compass bayCompass() {
    return compass;
  }

  @Override
  public String toString() {
    return "Compass{" +
        "name='" + name + '\'' +
        '}';
  }
}
