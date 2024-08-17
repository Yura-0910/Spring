package ru.lainer.springcore.ioc_container.di.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnotherStudent {

  private AnotherStudentIdCard anotherStudentIdCard;

  @Autowired
  //DI через setter
  public void setAnotherStudentIdCard(AnotherStudentIdCard anotherStudentIdCard) {
    this.anotherStudentIdCard = anotherStudentIdCard;
  }

  public void printInfo() {
    System.out.println("Student name: " + anotherStudentIdCard.getName());
    System.out.println("Student faculty: " + anotherStudentIdCard.getFaculty());
  }
}
