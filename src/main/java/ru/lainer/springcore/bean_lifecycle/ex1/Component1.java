package ru.lainer.springcore.bean_lifecycle.ex1;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class Component1 {

  public Component1() {
    System.out.println("Шаг один при создании bean-а Component1:: это вызов конструктора bean-а");
  }

  public void onlyPrint() {
    System.out.println("Component1 -> onlyPrint()");
  }

  @PostConstruct
  private void afterConstruct(){
    System.out.println("После шага один при создании bean-а = Component1");
  }
}
