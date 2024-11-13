package ru.lainer.springsecurity.shared.config.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("ru.lainer.springsecurity.*")
@EnableAspectJAutoProxy //Включаем AOP
public class Config7 {

}
