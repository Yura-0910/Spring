package ru.lainer.springsecurity.shared.repository;

import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.lainer.springsecurity.shared.entity.ERole;
import ru.lainer.springsecurity.shared.entity.Roles;

@Repository
@Profile({"loginPasswordInDataBase", "profileJWT"})
public interface RoleRepository extends JpaRepository<Roles, Long> {

  public Roles[] findByName(ERole role);

}
