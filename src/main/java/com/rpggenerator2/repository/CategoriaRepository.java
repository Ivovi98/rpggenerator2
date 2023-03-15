package com.rpggenerator2.repository;

import com.rpggenerator2.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    /*
    @Query("SELECT c.nomeAttributiCategoria FROM Categoria c")
    List<String> findAllNames();
    */
}