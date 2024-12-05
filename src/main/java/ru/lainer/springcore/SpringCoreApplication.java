package ru.lainer.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.validation.SimpleErrors;
import ru.lainer.springcore.aop.ex1.Bean26;
import ru.lainer.springcore.aop.ex1.Config26;
import ru.lainer.springcore.bean_lifecycle.ex1.Component1;
import ru.lainer.springcore.ioc_container.annotation_based.init_destroy.Bean8;
import ru.lainer.springcore.ioc_container.annotation_based.init_destroy.ConfigBean8;
import ru.lainer.springcore.ioc_container.annotation_based.postconstruct_predestroy.Bean7;
import ru.lainer.springcore.ioc_container.annotation_based.postconstruct_predestroy.ConfigBean6;
import ru.lainer.springcore.ioc_container.annotation_based.qualifier.ConfigStore;
import ru.lainer.springcore.ioc_container.annotation_based.qualifier.Magnet;
import ru.lainer.springcore.ioc_container.annotation_based.resource.ConfigMovie;
import ru.lainer.springcore.ioc_container.annotation_based.resource.SimpleMovieLister;
import ru.lainer.springcore.ioc_container.annotation_based.value_pkg.Bean5;
import ru.lainer.springcore.ioc_container.annotation_based.value_pkg.ConfigValue;
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
import ru.lainer.springcore.ioc_container.java_based.bean_dependencies.Bean11;
import ru.lainer.springcore.ioc_container.java_based.bean_dependencies.Bean15;
import ru.lainer.springcore.ioc_container.java_based.bean_dependencies.Config1011;
import ru.lainer.springcore.ioc_container.java_based.declaring_bean.Bean9;
import ru.lainer.springcore.ioc_container.java_based.declaring_bean.Config9;
import ru.lainer.springcore.ioc_container.java_based.my_import.Bean16;
import ru.lainer.springcore.ioc_container.java_based.my_import.Bean17;
import ru.lainer.springcore.ioc_container.java_based.my_import.Config17;
import ru.lainer.springcore.ioc_container.java_based.scope.Bean13;
import ru.lainer.springcore.ioc_container.java_based.scope.Config13;
import ru.lainer.springcore.spel.ex1.Bean22;
import ru.lainer.springcore.spel.ex1.Config22;
import ru.lainer.springcore.spel.ex2.Bean24;
import ru.lainer.springcore.spel.ex2.Config24;
import ru.lainer.springcore.type_conversion.built_in.Config20;
import ru.lainer.springcore.type_conversion.custom.Bean21;
import ru.lainer.springcore.type_conversion.custom.Config21;
import ru.lainer.springcore.validation.bean.Bean19;
import ru.lainer.springcore.validation.bean.Config18;
import ru.lainer.springcore.validation.objects.Person;
import ru.lainer.springcore.validation.objects.PersonConfig;
import ru.lainer.springcore.validation.objects.PersonValidator;


@SpringBootApplication
public class SpringCoreApplication {

  private static Component1 component1; //Для демонстрации использования @PostConstruct

  @Autowired
  public SpringCoreApplication(Component1 component1) {
    this.component1 = component1;
  }

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

    //Для демонстрации такого типа Autowired, как "byType"
    ApplicationContext contextByType = new AnnotationConfigApplicationContext(ConfigByType.class);
    Bean3 bean3 = contextByType.getBean(Bean3.class);
    bean3.printInfo();

    /*
      Для демонстрации @Autowire:: внедряем объект типа "generic interface", где
      типа generic-а используется как "Qualifier" (qualifier = String и qualifier = Integer)
    */
    ApplicationContext qualifier = new AnnotationConfigApplicationContext(ConfigStore.class);
    Magnet magnet = qualifier.getBean(Magnet.class);
    magnet.print();
    magnet.printDouble();
    magnet.printMapDouble();
    magnet.printArrayDouble();

    //Для демонстрации использования @Resource
    ApplicationContext movie = new AnnotationConfigApplicationContext(ConfigMovie.class);
    SimpleMovieLister movieLister = movie.getBean(SimpleMovieLister.class);
    movieLister.printMovies();

    //Для демонстрации использования @Value
    ApplicationContext valueCntx = new AnnotationConfigApplicationContext(ConfigValue.class);
    Bean5 bean5 = valueCntx.getBean(Bean5.class);
    bean5.printInfo();

    //Для демонстрации использования @PostConstruct и @PreDestroy
    ApplicationContext bean6_7Context = new AnnotationConfigApplicationContext(ConfigBean6.class);
    Bean7 bean7 = bean6_7Context.getBean(Bean7.class);
    bean7.printInfo();

    //Для демонстрации использования initMethod и destroyMethod
    ApplicationContext bean8Context = new AnnotationConfigApplicationContext(ConfigBean8.class);
    Bean8 bean8 = bean8Context.getBean(Bean8.class);
    bean8.printInfo();

    //Для демонстрации объявления bean-а в "default method-е" интерфейса
    ApplicationContext context9 = new AnnotationConfigApplicationContext(Config9.class);
    Bean9 bean9 = context9.getBean(Bean9.class);
    bean9.printInfo();

    //Для демонстрации внедрения одного бина в другой бин (два способа)
    ApplicationContext context1011 = new AnnotationConfigApplicationContext(Config1011.class);
    Bean11 bean11 = context1011.getBean(Bean11.class);
    bean11.printInfo();
    Bean15 bean15 = context1011.getBean(Bean15.class);
    bean15.printInfo();

    //Для демонстрации установки бину другого Scope
    ApplicationContext context13 = new AnnotationConfigApplicationContext(Config13.class);
    Bean13 bean13 = context13.getBean(Bean13.class);
    bean13.increaseCount();
    bean13.increaseCount();

    //Для демонстрации аннотации Import
    ApplicationContext context14 = new AnnotationConfigApplicationContext(Config17.class);
    Bean16 bean16 = context14.getBean(Bean16.class);
    Bean17 bean17 = context14.getBean(Bean17.class);
    bean16.printInfo();
    bean17.printInfo();

    //Валидация объекта (через интерфейс Validator)
    ApplicationContext context15 = new AnnotationConfigApplicationContext(PersonConfig.class);
    Person person = context15.getBean(Person.class);
    PersonValidator personValidator = context15.getBean(PersonValidator.class);
    SimpleErrors errors = context15.getBean(SimpleErrors.class);
    personValidator.validate(person, errors);
    if (errors.hasErrors()) {
      System.out.println("Ошибки валидации:");
      errors.getFieldErrors().forEach(System.out::println);
    }

    //Валидация бина через аннотации
    ApplicationContext context16 = new AnnotationConfigApplicationContext(Config18.class);
    Bean19 bean19 = context16.getBean(Bean19.class);
    bean19.printInfo();

    //Для демонстрации "Type Conversion" через интерфейс ConversionService
    ApplicationContext context20 = new AnnotationConfigApplicationContext(Config20.class);
    ConversionService conversionService = context20.getBean(ConversionService.class);
    System.out.println("Преобразование " + conversionService.convert("12345", Integer.class) +
        " в Integer");

    //Для демонстрации пользовательского "Type Conversion" через интерфейс Converter
    ApplicationContext context21 = new AnnotationConfigApplicationContext(Config21.class);
    GenericConversionService genConvService = context21.getBean(GenericConversionService.class);
    Bean21 bean21 = genConvService.convert("9,13.0", Bean21.class);
    System.out.println("Преобразовали Bean21 из строки в объект " + bean21);

    //Для демонстрации использования SPeL в объявлении бина
    ApplicationContext context22 = new AnnotationConfigApplicationContext(Config22.class);
    Bean22 bean22 = context22.getBean(Bean22.class);
    System.out.println("SPeL: = " + bean22.getField1());
    System.out.println("SPeL: = " + bean22.getField2());
    System.out.println("SPeL: = " + bean22.isField3());
    System.out.println("SPeL: = " + bean22.isField4());
    System.out.println("SPeL: = " + bean22.isField5());
    System.out.println("SPeL: = " + bean22.getField6());

    //Для демонстрации использования SPeL в ручном режиме
    ApplicationContext context24 = new AnnotationConfigApplicationContext(Config24.class);
    Bean24 bean24 = context24.getBean(Bean24.class);
    bean24.parsingManually();

    //Для демонстрации работы AOP
    ApplicationContext context26 = new AnnotationConfigApplicationContext(Config26.class);
    Bean26 bean26 = context26.getBean(Bean26.class);
    bean26.printInfo();
    bean26.printInfo2();
    try {
      bean26.throwAnException();
    }
    catch (NullPointerException e){
      System.out.println("Обработали исключение типа NullPointerException");
    }
    int result = bean26.forAround();
    System.out.println("Новый результат метода forAround = " + result);

    //Для демонстрации использования @PostConstruct
    component1.onlyPrint();

    //Для демонстрации использования интерфейса BeanPostProcessor
    //Достаточно создать бин MyBeanPostProcessor и бин Bean27, ничего другого не надо.
  }
}
