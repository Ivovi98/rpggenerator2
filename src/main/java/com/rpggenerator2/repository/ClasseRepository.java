package com.rpggenerator2.repository;

import com.rpggenerator2.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClasseRepository extends JpaRepository<Classe, Long> {

    @Query("SELECT c FROM Classe c WHERE c.nomeClasse = ?1")
    Classe findByNomeClasse(String nomeClasse);
}