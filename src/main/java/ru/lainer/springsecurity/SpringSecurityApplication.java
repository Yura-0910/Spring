package ru.lainer.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityApplication.class, args);
	}

	//TODO попробовать использовать базу H2
	//TODO для H2 нужен драйвер нужной версии
	//TODO развернуть БД Postgress + backEnd на виртуальной машине (Cloud.ru) ?
	//TODO Описать про профили и про запросы для каждого профиля в ReadMe.md
	//TODO создать тесты
	//TODO прокоментировать весь код (в стиле Java Doc) + ReadMe.md
	//TODO из ServiceSignUp вынести общую функциональность касающяюся заполнения MyUSER ролями
	//TODO общую функциональность из ServiceSignUpJwt и ServiceSignUp выделить в
	// отдельный класс, или отрефакторить эти сервисы
	//TODO Refresh tocken, кэш:: добавить в issue проекта Spring Security на git.hub
	//TODO код для Bearer и для JWT

}
