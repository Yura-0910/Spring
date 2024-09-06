package ru.lainer.springcore.validation.bean;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class Bean18 {

  @Size(min = 5, max = 9, message = "name must be between 5 and 9 characters")
  private String name;

  @Min(value = 0, message = "age must be greater than 0")
  private int age;

  public Bean18(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }
}
