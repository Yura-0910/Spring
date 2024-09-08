package ru.lainer.springcore.spel.ex1;

import org.springframework.beans.factory.annotation.Value;

public class Bean22 {

  //Arithmetic Operators
  @Value("#{19 + 1}") // 20
  private int field1;
  @Value("#{36 / 2}") // 19
  private String field2;

  //Logical Operators
  @Value("#{1 eq 1}") // true
  private boolean field3;
  @Value("#{1 != 1}") // false
  private boolean field4;

  //Ссылка на бин Bean23
  @Value("#{bean23}")
  private Bean23 bean23;
  @Value("#{bean23.field2 >= 13}")
  private boolean field5;
  @Value("#{bean23.field1 + ' Hello World'}")
  private String field6;

  public int getField1() {
    return field1;
  }

  public String getField2() {
    return field2;
  }

  public boolean isField3() {
    return field3;
  }

  public boolean isField4() {
    return field4;
  }

  public boolean isField5() {
    return field5;
  }

  public String getField6() {
    return field6;
  }

  public void printInfo() {
    System.out.println("Bean22 -> printInfo()");
    bean23.printInfo();
  }
}
