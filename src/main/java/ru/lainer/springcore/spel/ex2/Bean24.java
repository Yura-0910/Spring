package ru.lainer.springcore.spel.ex2;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

public class Bean24 {

  public void parsingManually() {
    //Вручную:: ExpressionParser может парсить строку
    ExpressionParser expressionParser = new SpelExpressionParser();
    Expression expression = expressionParser.parseExpression("'Any string'");
    String result = (String) expression.getValue();
    System.out.println("SPeL (ExpressionParser):: = " + result);

    //Вручную:: с использованием SPeL можно вызывать методы
    Expression expression2 = expressionParser.parseExpression("'Any str'.length()");
    Integer result2 = (Integer) expression2.getValue();
    System.out.println("SPeL(после вызова метода) = " + result2);

    //Вручную:: с использованием SPeL можно вызывать конструктор
    Expression expression3 = expressionParser
        .parseExpression("new String('Any string').length()");
    Integer result3 = (Integer) expression3.getValue();
    System.out.println("SPeL (вызвали конструктор, потом метод):: = " + result3);

    //Из "EvaluationContext" извлекаем значение поля, заданного в "Expression"
    Class25 class25 = new Class25("Kompass", 13);
    Expression expression4 = expressionParser.parseExpression("field1");
    EvaluationContext context = new StandardEvaluationContext(class25);
    String result4 = (String) expression4.getValue(context);
    System.out.println("SPeL (извлекаем значение поля из объекта):: = " + result4);

    //Извлекаем значение поля из объекта и используем операцию сравнения в SPeL
    Expression expression5 = expressionParser.parseExpression("field2 > 9");
    Boolean result5 = (Boolean) expression5.getValue(context);
    System.out.println("SPeL (field2 > 9):: = " + result5);
  }

}
