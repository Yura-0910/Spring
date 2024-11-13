package ru.lainer.springsecurity.shared.dto;

import lombok.Data;

@Data
public class SignInDTO {
  String login;
  String password;
}
