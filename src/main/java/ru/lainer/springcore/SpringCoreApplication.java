package ru.lainer.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.lainer.springcore.ioc_container.autowiring.by_name.Bean1;
import ru.lainer.springcore.ioc_container.autowiring.by_name.ConfigByName;
import ru.lainer.springcore.ioc_container.autowiring.by_type.Bean3;
import ru.lainer.springcore.ioc_container.autowiring.by_type.ConfigByType;
import ru.lainer.springcore.ioc_container.di.setter.AnotherStudent;
import ru.lainer.springcore.ioc_container.di.setter.ConfigForDISetters;
import ru.lainer.springcore.ioc_container.instantiation.ifm.ConfigForCourses;
import ru.lainer.springcore.ioc_container.instantiation.ifm.Courses;
import ru.lainer.springcore.ioc_container.instantiation.sfm.ConfigForFish;
import ru.lainer.springcore.ioc_container.instantiation.sfm.Fish;
import ru.lainer.springcore.ioc_container.di.constructor.Config;
import ru.lainer.springcore.ioc_container.di.constructor.Student;
import ru.lainer.springcore.ioc_container.instantiation.sfm_two.Compass;
import ru.lainer.springcore.ioc_container.instantiation.sfm_two.ConfigForCompass;


@SpringBootApplication
public class SpringCoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringCoreApplication.class, args);

    //Для DI через конструктор
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    Student student = context.getBean(Student.class);
    student.printInfo();

    //Для DI через setter
    ApplicationContext contextForSetter = new AnnotationConfigApplicationContext(
        ConfigForDISetters.class);
    AnotherStudent anotherStud = contextForSetter.getBean(AnotherStudent.class);
    anotherStud.printInfo();

    //Касается создания\Instantiation Bean-ов
    ApplicationContext contextTwo = new AnnotationConfigApplicationContext(ConfigForFish.class);
    //При создании(Instantiation) данного Bean-а был использован "Static Factory Method"
    Fish krasnoperkaFish = (Fish) contextTwo.getBean("krasnoperka");
    System.out.println(krasnoperkaFish);

    //При создании(Instantiation) данного Bean-а был использован "Static Factory Method"
    Fish plotvaFish = (Fish) contextTwo.getBean("plotva");
    System.out.println(plotvaFish);

    //При создании(Instantiation) данного Bean-а был использован "Static Factory Method"
    ApplicationContext contextThree = new AnnotationConfigApplicationContext(
        ConfigForCompass.class);
    Compass compass = (Compass) contextThree.getBean("compass");
    System.out.println(compass);

    //При создании(Instantiation) данного Bean-а был использован "Instance Factory Method"
    ApplicationContext contextFour = new AnnotationConfigApplicationContext(ConfigForCourses.class);
    Courses coursesDSA = (Courses) contextFour.getBean("dsa");
    coursesDSA.getCourseDetail();

    //При создании(Instantiation) данного Bean-а был использован "Instance Factory Method"
    Courses coursesJava = (Courses) contextFour.getBean("java");
    coursesJava.getCourseDetail();

    //Для демонстрации такого типа Autowired, как "byName"
    ApplicationContext contextByName = new AnnotationConfigApplicationContext(ConfigByName.class);
    Bean1 bean1 = contextByName.getBean(Bean1.class);
    bean1.printInfo();
  }

}
