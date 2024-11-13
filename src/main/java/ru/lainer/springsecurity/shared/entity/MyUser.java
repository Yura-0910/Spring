package ru.lainer.springsecurity.shared.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;
import lombok.Data;
import org.springframework.context.annotation.Profile;

@Data
@Entity
@Table(name = "users")
@Profile("loginPasswordInDataBase")
public class MyUser {

  @Id
  //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
  //@SequenceGenerator(name = "user_gen", sequenceName = "users_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id_pk")
  private Long id;

  @Column(name = "login")
  private String username;

  @Column(name = "password")
  private String password;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "USERS_ROLES",
      joinColumns = {@JoinColumn(name = "user_id_pk")},
      inverseJoinColumns = {@JoinColumn(name = "role_id_pk")})
  private List<Roles> listRoles;

  public MyUser() {
  }

  public MyUser(String username, String password, Set<ERole> roles) {
    this.username = username;
    this.password = password;
  }
}
