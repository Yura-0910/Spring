package ru.lainer.springsecurity.shared.dto;

import lombok.Data;

@Data
public class SignUpDTO {
  String login;
  String password;
  String[] roles;
}
