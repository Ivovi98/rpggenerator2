package com.rpggenerator2.repository;

import com.rpg.rpgGenerator.entity.Abilita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;


public interface AbilitaRepository extends JpaRepository<Abilita, String> {
    Abilita findByNomeAbilita(String nomeAbilita);

    @Query("SELECT a FROM Abilita a WHERE a.nomeAttributiAbilita LIKE %?1%")
    List<Abilita> findAllByNomeAttributiAbilitaContaining(String nomeAttributiAbilita);
}