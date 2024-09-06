package ru.lainer.springcore.validation.bean;

import jakarta.validation.ConstraintViolationException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorHandlingAspect {

  //@Around - может перехватывать исключения при вызове заданного метода
  @Around("execution(* ru.lainer.springcore.validation.bean.Config18.bean19(..))")
  Object advice1(ProceedingJoinPoint prcdJoinPoint) throws Throwable {
    Object ResultatTargetMethoda = null;
    try {
      //Вызываем метод bean19(..) и перехватываем исключение
      ResultatTargetMethoda = prcdJoinPoint.proceed();
    } catch (ConstraintViolationException e) {
      System.out.println("При создании Bean19 произошла ошибка валидации:: " + e.getMessage());
    }
    return ResultatTargetMethoda;
  }
}
