package ru.lainer.springcore.ioc_container.instantiation.ifm;

public class JavaCourses implements Courses{

  @Override
  public void getCourseDetail() {
    System.out.println("Java courses");
  }
}
