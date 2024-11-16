package ru.lainer.springsecurity;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import ru.lainer.springsecurity.shared.dto.SignUpDTO;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test", "profileJWT"})
@TestMethodOrder(OrderAnnotation.class)
class JwtTests {

  @Autowired
  private TestRestTemplate testRestTemplate;
  private static String jwtToken;

  //Регистрация нового пользователя
  @Test
  @Order(1)
  void test_001_signUp() {
    String tmpToken = null;
    String strURL = "/auth/signUpJWT";
    String answer = "Вы успешно зарегистрировались, ваш токен::";

    SignUpDTO signUpDTO = new SignUpDTO();
    signUpDTO.setLogin("jwt_user");
    signUpDTO.setPassword("jwt_pwd");
    signUpDTO.setRoles(new String[]{"USER", "ADMIN"});

    ResponseEntity<String> response = testRestTemplate.postForEntity(strURL, signUpDTO,
        String.class);

    assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    assertThat(response.getBody(), containsString(answer));

    //Извлекаем JWT токен из тела ответа
    tmpToken = response.getBody();
    if (tmpToken != null) {
      jwtToken = tmpToken.substring(answer.length() + 1);
    }
  }

  //Проверяем аутентификацию
  @Test
  @Order(2)
  void test_002_signIn() {
    String strURL = "/auth/signInJWT";
    String answer = "jwt_user:: Вы успешно прошли аутентификацию";

    HttpHeaders headers = new HttpHeaders();
    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    if (jwtToken != null) {
      headers.set("Authorization", "Bearer " + jwtToken);
      HttpEntity<String> entity = new HttpEntity<String>(headers);

      ResponseEntity<String> responseEntity = testRestTemplate.exchange(strURL, HttpMethod.POST,
          entity, String.class);
      assertThat(responseEntity.getStatusCode(), is(HttpStatus.ACCEPTED));
      assertThat(responseEntity.getBody(), containsString(answer));
    }
    else {
      throw new RuntimeException("Не получен токен из первого теста");
    }
  }
}
