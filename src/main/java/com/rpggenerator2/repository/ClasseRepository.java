package com.rpggenerator2.repository;

import com.rpg.rpgGenerator.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClasseRepository extends JpaRepository<Classe, String> {

    @Query("SELECT c FROM Classe c WHERE c.nomeClasse = ?1")
    Classe findByNomeClasse(String nomeClasse);
}