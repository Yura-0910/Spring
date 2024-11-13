package ru.lainer.springsecurity.shared.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectFirst {

  /**
   * Перехватываем любые ошибки при работе метода "extractUserName" (это где извлекают
   * "Claims" из JWT)
   */
  @Around("execution(public String extractUserName(String))")
  public Object adviceSecond(ProceedingJoinPoint pjp) {
    Object result = null;
    try {
      result = pjp.proceed();
    } catch (Throwable e) {
      return "UserNotFoundInJWT";
    }
    return result;
  }
}
