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
public class Descrizione {
    @Id
    @Column(nullable = false)
    private Long id;

    @Column(name = "descrizione")
    private String descrizione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_abilita")
    private Abilita abilita;

    @CreatedDate
    @Column(name = "data_creazione")
    private Timestamp dataCreazione;

    @LastModifiedDate
    @Column(name = "data_ultima_modifica")
    private Timestamp dataUltimaModifica;

    @Version
    @Column(name = "versione")
    private int versione;
}