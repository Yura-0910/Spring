package ru.lainer.springsecurity.shared.filters;


import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.security.access.AccessDeniedException;

/*
 Пользовательский "Security Filter"\"Filter":: вызывается при каждом запросе
 */
public class Filter2 implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
      FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;

    String dataFromHeader = request.getHeader("myHeader");

    //Срабатывает при каждом запросе, по этому в запросе может не быть  Header = "myHeader"
    if (dataFromHeader != null) {
      System.out.println("Filter2:: в запросе есть Header = myHeader");
      System.out.println("Filter2:: Данные из  myHeader = " + dataFromHeader);
      int length = dataFromHeader.length();
      if (length < 3) {
        throw new AccessDeniedException("Длина myHeader меньше 3 символов");
      }
    } else {
      System.out.println("Filter2:: в запросе нет Header = myHeader");
    }
    //вызываем остальные фильтры в цепочке.
    filterChain.doFilter(request, response);
  }
}
