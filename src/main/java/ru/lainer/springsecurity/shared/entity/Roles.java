package ru.lainer.springsecurity.shared.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import java.util.List;
import lombok.Data;
import org.springframework.context.annotation.Profile;

@Data
@Entity
@Table(name = "roles")
@Profile("loginPasswordInDataBase")
public class Roles {

  @Id
  //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_gen")
  //@SequenceGenerator(name = "role_gen", sequenceName = "roles_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "role_id_pk")
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20, name = "role")
  private ERole name;

  //@ManyToMany(mappedBy="listRoles")
  @Transient
  private List<MyUser> myUsersList;

  public Roles() {
  }

  public Roles(Long id, ERole name) {
    this.id = id;
    this.name = name;
  }
}

