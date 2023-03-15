package com.rpggenerator2.controller;

import com.rpg.rpgGenerator.entity.Categoria;
import com.rpg.rpgGenerator.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorie")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public List<String> findAllNames() {
        return categoriaService.findAllNames();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Enum id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> insertCategoria(@RequestBody Categoria categoria) {
        Categoria savedCategoria = categoriaService.insertCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Enum id, @RequestBody Categoria categoria) {
        Optional<Categoria> existingCategoria = categoriaService.findById(id);
        if (existingCategoria.isPresent()) {
            categoria.setNomeAttributiCategoria(existingCategoria.get().getNomeAttributiCategoria());
            Categoria savedCategoria = categoriaService.save(categoria);
            return ResponseEntity.ok(savedCategoria);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Enum id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria.isPresent()) {
            categoriaService.delete(categoria.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}