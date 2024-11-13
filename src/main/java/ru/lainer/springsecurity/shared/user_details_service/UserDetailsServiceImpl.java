package ru.lainer.springsecurity.shared.user_details_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.lainer.springsecurity.shared.entity.MyUser;
import ru.lainer.springsecurity.shared.repository.UserRepository;
import ru.lainer.springsecurity.shared.user_details.UserDetailsImpl;

/**
 * Для работы со Spring Security надо обязательно реализовать интерфейс UserDetailsService
 */
@Service
@Profile(value = {"loginPasswordInDataBase", "basicAuth", "profileJWT"})
public class UserDetailsServiceImpl implements UserDetailsService {
  private UserRepository userRepository;

  @Autowired
  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    MyUser myUser = null;
    try {
      /*
       * По "username":: извлекаем из БД пользователя (MyUser) с зашифрованным паролем,
       * пароль автоматически расшифровывается через PasswordEncoder
       */
      myUser = userRepository.findByUsername(username);
    } catch (Exception ex) {
      throw new UsernameNotFoundException("Ошибка при извлечении MyUser-a из БД");
    }
    return new UserDetailsImpl(myUser);
  }
}
