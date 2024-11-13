package ru.lainer.springsecurity.shared.services;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.lainer.springsecurity.shared.dto.SignUpDTO;
import ru.lainer.springsecurity.shared.entity.ERole;
import ru.lainer.springsecurity.shared.entity.MyUser;
import ru.lainer.springsecurity.shared.entity.Roles;
import ru.lainer.springsecurity.shared.repository.RoleRepository;
import ru.lainer.springsecurity.shared.repository.UserRepository;

/**
 * Здесь происходит регистрация нового пользователя
 */
@Service
@RequiredArgsConstructor
@Profile("profileJWT")
public class ServiceSignUpJwt {
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final RoleRepository roleRepository;
  private final ServiceJwt serviceJwt;

  /**
   * @param signUpDTO данные пользователя
   * @return токен
   */
  public ResponseEntity<String> signUp(SignUpDTO signUpDTO)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    if (userRepository.existsByUsername(signUpDTO.getLogin())) {
      return new ResponseEntity<>("Уже есть пользователь с таким именем", HttpStatus.IM_USED);
    }

    MyUser myUser = new MyUser();
    myUser.setUsername(signUpDTO.getLogin());
    myUser.setPassword(passwordEncoder.encode(signUpDTO.getPassword())); //Шифруем пароль

    List<Roles> listRoles = new ArrayList<>();
    Long id = 0L;
    ERole eRole = null;
    Roles[] arrayOfRoles = null;
    for (String role : signUpDTO.getRoles()) {
      if (!role.equals("USER") && !role.equals("MODERATOR") && !role.equals("ADMIN")) {
        return new ResponseEntity<>("Такая роль не существует", HttpStatus.NOT_FOUND);
      } else {
        eRole = ERole.valueOf(role);
        arrayOfRoles = roleRepository.findByName(eRole);
        if (arrayOfRoles.length > 0) {
          id = arrayOfRoles[0].getId();
          //Что бы не сохранять каждый раз одну и ту же Role: добавляем в Role её id
          listRoles.add(new Roles(id, eRole));
        } else {
          return new ResponseEntity<>("В БД нет такой роли", HttpStatus.NOT_FOUND);
        }
      }
    }

    myUser.setListRoles(listRoles);
    userRepository.save(myUser);

    String token = serviceJwt.generateToken(myUser);

    return new ResponseEntity<>("Вы успешно зарегистрировались"
        + ", ваш токен:: " + token, HttpStatus.CREATED);
  }
}
