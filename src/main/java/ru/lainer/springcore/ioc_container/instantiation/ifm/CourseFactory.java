package ru.lainer.springcore.ioc_container.instantiation.ifm;

import org.springframework.stereotype.Component;

@Component
public class CourseFactory {

  //"Instance Factory Method" (перегруженный)
  public Courses addCourse() {
    return new DSACourses();
  }

  //"Instance Factory Method" (перегруженный)
  public Courses addCourse(String name) {
    return new JavaCourses();
  }
}
