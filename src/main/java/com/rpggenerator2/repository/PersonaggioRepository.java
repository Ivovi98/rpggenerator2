package com.rpggenerator2.repository;

import com.rpggenerator2.entity.Personaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PersonaggioRepository extends JpaRepository<Personaggio, Long> {
    /*
    @Query("SELECT p FROM Personaggio p WHERE p.nomePersonaggio = ?1")
    Personaggio findByNomePersonaggio(String nomePersonaggio);

    @Query("SELECT p FROM Personaggio p WHERE p.classePersonaggio = ?1")
    List<Personaggio> findAllByClassePersonaggio(String classePersonaggio);
    */
}