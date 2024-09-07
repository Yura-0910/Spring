package ru.lainer.springcore.type_conversion.custom;

import org.springframework.core.convert.converter.Converter;

public class StringToEmployeeConverter implements Converter<String, Bean21>{

  @Override
  public Bean21 convert(String source) {
    String[] arrOfStrings = source.split(",");
    return new Bean21(Long.valueOf(arrOfStrings[0]), Double.valueOf(arrOfStrings[1]));
  }
}
