package com.br.puc.beachtennis.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Long idUser;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "ds_senha",length = 60)
    private String password;

    @Column(name = "full_name", length = 200)
    private String fullName;

}