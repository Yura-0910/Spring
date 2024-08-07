package ru.lainer.springcore.ioc_container.introduction;


public class StudentIdCard {
 String name;
 String faculty;

  public StudentIdCard(String name, String faculty) {
    this.name = name;
    this.faculty = faculty;
  }

  public String getName() {
    return name;
  }

  public String getFaculty() {
    return faculty;
  }
}
