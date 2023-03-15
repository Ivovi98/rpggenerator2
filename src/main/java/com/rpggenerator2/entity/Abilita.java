package com.rpggenerator2.entity;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.sql.Timestamp;

@ToString
@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Abilita {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private String nomeAttributiAbilita;

    @Column
    private String nomeAbilita;

    @Column
    private String descrizioneAbilita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nomeAttributiClasse")
    private Classe nomeAttributiClasse;

    @CreatedDate
    @Column
    private Timestamp dataCreazione;

    @LastModifiedDate
    @Column
    private Timestamp dataUltimaModifica;

    @Version
    @Column
    private int versione;
}
