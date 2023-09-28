package com.br.puc.beachtennis.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

/**
 * @author Idair Junior Pereira <ijpereira@viptech.com.br, idair_junior@hotmail.com>
 */
@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "team")
public class Team {

    @Column(name = "id_team")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long idTeam;

    @Column(name = "nm_player")
    private String nmPlayer;

    @Column(name = "ds_team")
    private String dsTeam;

}

