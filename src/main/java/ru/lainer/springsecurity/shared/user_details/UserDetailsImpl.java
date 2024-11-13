package ru.lainer.springsecurity.shared.user_details;

import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.lainer.springsecurity.shared.entity.MyUser;

public class UserDetailsImpl implements UserDetails {
  private MyUser myUser;

  public UserDetailsImpl(MyUser myUser) {
    this.myUser = myUser;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return myUser.getListRoles().stream()
        .map(tmpRole -> new SimpleGrantedAuthority(tmpRole.toString()))
        .collect(Collectors.toList());
  }

  @Override
  public String getPassword() {
    return myUser.getPassword();
  }

  @Override
  public String getUsername() {
    return myUser != null ? myUser.getUsername() : "UserNotFoundInJWT";
  }

  //Из интерфейса UserDetails наследуются еще методы с дефолтной реализацией
}
