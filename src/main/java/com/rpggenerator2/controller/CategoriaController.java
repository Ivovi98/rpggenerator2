package com.rpggenerator2.controller;

import com.rpggenerator2.entity.Categoria;
import com.rpggenerator2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria.isPresent()) {
            return ResponseEntity.ok(categoria.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> insertCategoria(@RequestBody Categoria categoria) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            categoria.setDataCreazione(timestamp);
            Categoria c = categoriaService.save(categoria); //APPOGGINO
            if(c == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(c, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        Optional<Categoria> existingCategoria = categoriaService.findById(id);

        if (!existingCategoria.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        } else {
            Categoria categoriaDiAppoggio = existingCategoria.get();
            categoriaDiAppoggio.setNomeAttributiCategoria(categoria.getNomeAttributiCategoria());
            categoriaDiAppoggio.setDescrizione(categoria.getDescrizione());
            categoriaDiAppoggio.setVersione(categoria.getVersione());
            categoriaDiAppoggio.setDataUltimaModifica(categoria.getDataUltimaModifica());
            Categoria categoriaAggiornata = categoriaService.save(categoriaDiAppoggio);
            return new ResponseEntity<>(categoriaAggiornata, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        Optional<Categoria> categoria = categoriaService.findById(id);
        if (categoria.isPresent()) {
            categoriaService.delete(categoria.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*
    @GetMapping
    public List<String> findAllNames() {
        return categoriaService.findAllNames();
    }
    */
}