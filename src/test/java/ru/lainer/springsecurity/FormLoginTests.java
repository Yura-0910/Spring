package ru.lainer.springsecurity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.lainer.springsecurity.shared.dto.SignUpDTO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test", "loginPasswordInDataBase"})
@TestMethodOrder(OrderAnnotation.class)
class FormLoginTests {
  @Autowired private WebApplicationContext webApplicationContext;
  @Autowired private TestRestTemplate testRestTemplate;
  private MockMvc mockMvc;

  //Проверяем, что можем зарегистрировать нового пользователя
  @Test
  @Order(1)
  void test_001_signUp() {
    String strURL = "/api/signup";

    SignUpDTO signUpDTO = new SignUpDTO();
    signUpDTO.setLogin("form_user");
    signUpDTO.setPassword("form_pwd");
    signUpDTO.setRoles(new String[]{"USER", "ADMIN"});

    ResponseEntity<String> response = testRestTemplate.postForEntity(strURL, signUpDTO,
        String.class);
    assertThat(response.getStatusCode(), is(HttpStatus.CREATED));
    assertThat(response.getBody(), is("Вы успешно зарегистрировались"));
  }

  @BeforeEach
  public void setup() throws Exception {
    this.mockMvc = MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .apply(springSecurity())
        .build();
  }

  //Проверяем аутентификацию для случая "FormLogin" + логин\пароль в БД
  @Test
  @Order(2)
  void test_002_auth() throws Exception {
    mockMvc
        .perform(formLogin("/login")
            .user("form_user")
            .password("form_pwd"))
        .andExpect(authenticated()
            .withUsername("form_user"))
        .andExpect(redirectedUrl("/success"));
  }

  //Проверяем, что при неправильном пароле:: аутентификация не проходит. Логин\пароль в БД
  @Test
  @Order(3)
  void test_003_auth_fail() throws Exception {
    mockMvc
        .perform(formLogin("/login")
            .user("form_user")
            .password("form_pwd_fail"))
        .andExpect(unauthenticated())
        .andExpect(redirectedUrl("/error"));
  }
}
