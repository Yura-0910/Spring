package ru.lainer.springsecurity;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.hamcrest.CoreMatchers.containsString;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles({"test", "basicAuth"})
public class BasicAuthTests {

  @Autowired
  private TestRestTemplate testRestTemplate;
  @Autowired
  private WebApplicationContext webApplicationContext;
  private MockMvc mockMvc;

  @BeforeEach
  public void setup() throws Exception {
    this.mockMvc = MockMvcBuilders
        .webAppContextSetup(webApplicationContext)
        .apply(springSecurity())
        .build();
  }

  //Проверяем Basic аутентификацию. Логин и пароль в БД
  @Test
  void test_001_basicAuth() throws Exception {
    this.mockMvc
        .perform(get("/api/basicAuth")
            .with(httpBasic("basic_user", "p56")))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content()
            .string(containsString(
                "Аутентификация прошла успешно. Доступ к этому ресурсу:: разрешен")));
  }

  //Проверяем, что при неправильном пароле:: аутентификация - не успешная. Логин и пароль в БД
  @Test
  void test_002_unauthorized() throws Exception {
    this.mockMvc
        .perform(get("/api/basicAuth")
            .with(httpBasic("basic_user", "test_pwd")))
        .andExpect(status().isUnauthorized());
  }
}
