package ru.lainer.springcore.ioc_container.di.setter;


public class AnotherStudentIdCard {
 String name;
 String faculty;

  private AnotherStudentIdCard(String name, String faculty) {
    this.name = name;
    this.faculty = faculty;
  }

  //Static factory method
  public static AnotherStudentIdCard create(String name, String faculty) {
    return new AnotherStudentIdCard(name, faculty);
  }

  public String getName() {
    return name;
  }

  public String getFaculty() {
    return faculty;
  }
}
