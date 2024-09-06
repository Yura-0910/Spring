package ru.lainer.springcore.type_conversion.built_in;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;

@Configuration
@ComponentScan("ru.lainer.springcore.type_conversion.built_in")
public class Config20 {

  @Bean
  public ConversionService conversionService() {
    return new DefaultConversionService();
  }
}
