package ru.lainer.springcore.bean_lifecycle.ex2;

import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(@NotNull Object bean, @NotNull String beanName)
      throws BeansException {
    if (bean instanceof Bean27 bean27) {
      System.out.println("Действия перед инициализацией bean-a " + beanName);
      bean27.initialStr1 = "C3Po Robot";
      System.out.println("bean27.initialStr1 = " + bean27.initialStr1);
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(@NotNull Object bean, @NotNull String beanName)
      throws BeansException {
    if (bean instanceof Bean27 bean27) {
      System.out.println("Действия после инициализации bean-a " + beanName);
      bean27.initialStr2 = "Darth Vader";
      System.out.println("bean27.initialStr2 = " + bean27.initialStr2);
    }
    return bean;
  }
}
