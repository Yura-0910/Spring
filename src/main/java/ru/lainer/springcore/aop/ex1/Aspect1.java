package ru.lainer.springcore.aop.ex1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Aspect1 {

  @Before("execution(public void ru.lainer.springcore.aop.ex1.Bean26.printInfo())")
  public void advice1() {
    System.out.println("Advice типа Before");
  }

  @After("execution(public void ru.lainer.springcore.aop.ex1.Bean26.printInfo())")
  public void advice11() {
    System.out.println("Advice типа After");
  }

  @AfterReturning(pointcut =
      "execution(public int ru.lainer.springcore.aop.ex1.Bean26.printInfo2())",
      returning = "returnValue")
  public void advice2(JoinPoint joinPoint, int returnValue) {
    System.out.println("Меняем Return Value у метода. Новый результат =  " + (returnValue + 1));
    System.out.println("Advice типа AfterReturning");
  }

  @AfterThrowing(pointcut =
      "execution(public void ru.lainer.springcore.aop.ex1.Bean26.throwAnException())",
      throwing = "npe")
  public void advice3(JoinPoint joinPoint, NullPointerException npe) {
    System.out.println("Advice типа AfterThrowing:: перехватили исключение = " + npe.getMessage());
  }

  @Around("execution(public int ru.lainer.springcore.aop.ex1.Bean26.forAround())")
  public Object advice4(ProceedingJoinPoint pjp) {
    System.out.println("---Advice типа Around---");
    System.out.println("---Перед вызовом метода forAround---");
    Object ResultatTargetMethoda = null;
    int resultAsInt = 0;
    try {
      ResultatTargetMethoda = pjp.proceed();
      resultAsInt = (int) ResultatTargetMethoda;
      resultAsInt = resultAsInt + 1;
      ResultatTargetMethoda = resultAsInt;
    } catch (Throwable throwable) {
      System.out.println("Перехватили исключение из Around advice:: " + throwable.getMessage());
      ResultatTargetMethoda = 13;
    }
    System.out.println("---После вызова метода forAround---");
    return ResultatTargetMethoda;
  }
}
