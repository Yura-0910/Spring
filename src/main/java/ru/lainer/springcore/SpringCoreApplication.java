package ru.lainer.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lainer.springcore.ioc_container.introduction.Config;
import ru.lainer.springcore.ioc_container.introduction.Student;


@SpringBootApplication
public class SpringCoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringCoreApplication.class, args);

    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    Student student = context.getBean(Student.class);
    student.printInfo();

  }

}
