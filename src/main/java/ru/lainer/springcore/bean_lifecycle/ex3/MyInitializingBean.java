package ru.lainer.springcore.bean_lifecycle.ex3;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;

public class MyInitializingBean implements InitializingBean {

  @Value("${initial.value}")
  private String initialString;

  @Override
  public void afterPropertiesSet() throws Exception {
    //Логика дополнительной инициализации
    initialString = initialString + " of Java";
    System.out.println("MyInitializingBean:: = " + initialString);

    //Проверка корректности настроек
    if (initialString.length() < 25) {
      initialString = initialString + " from Savra";
      System.out.println("MyInitializingBean:: = " + initialString);
    }
  }
}
