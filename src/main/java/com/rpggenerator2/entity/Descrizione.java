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
    private String iddescrizione;

    @Column
    private String descrizione;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idabilita")
    private Abilita idabilita;

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