package ru.lainer.springsecurity.shared.filters;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.lainer.springsecurity.shared.services.ServiceJwt;
import ru.lainer.springsecurity.shared.user_details_service.UserDetailsServiceImpl;

/**
 * Фильтр осуществляет аутентификацию
 */
@Component
@Profile("profileJWT")
@RequiredArgsConstructor
public class FilterAuthJWT extends OncePerRequestFilter {

  private final ServiceJwt serviceJwt;
  private final UserDetailsServiceImpl userDetailsServiceImpl;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    // Получаем токен из заголовка
    String authHeader = request.getHeader("Authorization");
    if(authHeader == null || !authHeader.startsWith("Bearer ")){
      filterChain.doFilter(request, response);
      return;
    }

    // Обрезаем префикс и получаем имя пользователя из токена
    String jwt = authHeader.substring("Bearer ".length());
    String username = serviceJwt.extractUserName(jwt);

    UserDetails userDetails = null;
    if (username != null && SecurityContextHolder.getContext().getAuthentication() == null &&
        !username.equals("UserNotFoundInJWT")){
      //Заполняем UserDetails данными из БД
      userDetails = userDetailsServiceImpl.loadUserByUsername(username);
    }
    else {
      filterChain.doFilter(request, response);
      return;
    }

    /*
     *  Верификация токена и аутентификация пользователя:
     *  при извлечении username из токена мы использовали метод "verifyWith",
     *  который задает SecretKey для верификации сигнатуры (это третья часть токена). И использовали
     *  метод "parseSignedClaims", который возвращает верифицированные "Claims". То есть
     *  если метод "parseSignedClaims" вернул верифицированные "Claims", значит был перед
     *  этим верифицирован токен:: значит переданный JWT токен подлинный.
     *  Таким образом остается только проверить, что не истекло время существования токена и
     *  провести аутентификацию

     * Если время жизни токена не истекло и если login\пароль из запроса (т.е. из JWT токена)
     * совпадает с login-ом\паролем из БД, то есть если аутентификация прошла успешно,
     * то наполняем SecurityContextHolder данными: логин, пароль, роль (которые прошли успешную
     * аутентификацию)
     */
    //Аутентификация внутри "if": точнее в методе isLoginAndPwdMatch
    if (userDetails != null && serviceJwt.isTokenNotExpired(jwt) &&
        serviceJwt.isLoginAndPwdMatch(userDetails.getUsername(),userDetails.getPassword())) {

      //Наполняем SecurityContextHolder данными
      SecurityContext context = SecurityContextHolder.createEmptyContext();
      UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
          userDetails.getUsername(),
          userDetails.getPassword(),
          userDetails.getAuthorities()
      );
      Object detailsFromRequest = new WebAuthenticationDetailsSource().buildDetails(request);
      authToken.setDetails(detailsFromRequest);
      context.setAuthentication(authToken);
      SecurityContextHolder.setContext(context);
    }

    filterChain.doFilter(request, response);
  }
}
