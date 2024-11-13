package ru.lainer.springsecurity.shared.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lainer.springsecurity.shared.entity.MyUser;

@Repository
@Profile(value = {"loginPasswordInDataBase", "basicAuth", "profileJWT"})
public interface UserRepository extends JpaRepository<MyUser, Long> {
  //Проверяем, есть ли в таблице "users" пользователь с таким "username"
 boolean existsByUsername(String username);
 MyUser findByUsername(String username);
}
