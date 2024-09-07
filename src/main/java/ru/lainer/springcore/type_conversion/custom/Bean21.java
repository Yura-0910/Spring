package ru.lainer.springcore.type_conversion.custom;

public class Bean21 {

  private long id;
  private double salary;

  public Bean21(long id, double salary) {
    this.id = id;
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Bean21{" +
        "id=" + id +
        ", salary=" + salary +
        '}';
  }
}
