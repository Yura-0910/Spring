package ru.lainer.springcore.type_conversion.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.GenericConversionService;

@Configuration
@ComponentScan("ru.lainer.springcore.type_conversion.custom")
public class Config21 {

  @Bean
  public StringToEmployeeConverter stringToEmployeeConverter() {
    return new StringToEmployeeConverter();
  }

  /*
   Создаем GenericConversionService, так как он реализует интерфейс ConverterRegistry,
   в котором есть метод addConverter(пользовательский конвертор)
   */
  @Bean
  public GenericConversionService genericConversionService() {
    GenericConversionService genericConversionService = new GenericConversionService();
    //Передаем на регистрацию пользовательский конвертер
    genericConversionService.addConverter(stringToEmployeeConverter());
    return genericConversionService;
  }
}
