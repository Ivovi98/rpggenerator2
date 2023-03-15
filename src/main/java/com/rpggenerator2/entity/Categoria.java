package com.rpggenerator2.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import javax.persistence.*;
import java.sql.Timestamp;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categoria {
   @Id
   @Column(nullable = false)
   private String idcategoria;

   @Column
   private String nomeAttributiCategoria;


   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "iddescrizione")
   private Descrizione iddescrizione;

   @CreatedDate
   @Column
   private Timestamp dataCreazione;

   @LastModifiedDate
   @Column
   private Timestamp dataUltimaModifica;

   @Version
   @Column
   private int versione;

   public Object getNomeAttributiCategoria() {
       Object o = null;
       return o;
   }

   public void setNomeAttributiCategoria(Object nomeAttributiCategoria) {

   }
}