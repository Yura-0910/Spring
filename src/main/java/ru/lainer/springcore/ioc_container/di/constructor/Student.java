package ru.lainer.springcore.ioc_container.di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {
  StudentIdCard studentIdCard;

  //DI через конструктор
  @Autowired
  public Student(StudentIdCard studentIdCard) {
    this.studentIdCard = studentIdCard;
  }

  public void printInfo() {
    System.out.println("Student name: " + studentIdCard.getName());
    System.out.println("Student faculty: " + studentIdCard.getFaculty());
  }
}
