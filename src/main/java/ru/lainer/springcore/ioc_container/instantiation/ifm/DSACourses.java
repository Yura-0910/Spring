package ru.lainer.springcore.ioc_container.instantiation.ifm;

public class DSACourses implements Courses {

  @Override
  public void getCourseDetail() {
    System.out.println("DSA");
  }
}
