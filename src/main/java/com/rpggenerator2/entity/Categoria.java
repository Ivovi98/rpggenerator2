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
public class Categoria {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(nullable = false)
   private Long id;

   @Column
   private String nomeAttributiCategoria;


   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_descrizione")
   private Descrizione descrizione;

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