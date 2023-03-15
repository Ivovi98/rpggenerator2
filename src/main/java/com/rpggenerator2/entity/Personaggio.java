package com.rpggenerator2.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Personaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long idpersonaggio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classe_idclasse")
    private Classe idclasse;

    @Column
    private String nomePersonaggio;

    @Column
    private String classePersonaggio;

    @Column
    private int livelloPersonaggio;

    @Column
    private int forzaPersonaggio;

    @Column
    private int intellijPersonaggio;

    @Column
    private int salutePersonaggio;

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