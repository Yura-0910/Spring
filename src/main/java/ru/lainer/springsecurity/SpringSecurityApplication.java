package ru.lainer.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	//TODO прокоментировать весь код (в стиле Java Doc) + ReadMe.md

	//TODO общую функциональность касающуюся заполнения MyUSER (из ServiceSignUpJwt и ServiceSignUp)
	// вынести в отдельный класс\метод (рефакторинг)

	//TODO для H2 нужен драйвер нужной версии (как в DBeaver, так и в IDEA)
}
