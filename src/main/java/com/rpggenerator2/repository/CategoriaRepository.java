package com.rpg.rpgGenerator.repository;

import com.rpg.rpgGenerator.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Enum> {

    @Query("SELECT c.nomeAttributiCategoria FROM Categoria c")
    List<String> findAllNames();
}