package ru.lainer.springcore.ioc_container.instantiation.ifm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.lainer.springcore.ioc_container.instantiation.ifm")
public class ConfigForCourses {
  private final CourseFactory courseFactory;

  @Autowired
  public ConfigForCourses(CourseFactory courseFactory) {
    this.courseFactory = courseFactory;
  }

  @Bean(name = "dsa")
  public Courses courseDSA() {
    //Instantiation с помощью "Instance Factory Method"
    return courseFactory.addCourse();
  }

  @Bean(name = "java")
  public Courses courseJava() {
    //Instantiation с помощью "Instance Factory Method"
    return courseFactory.addCourse("Hello");
  }
}
