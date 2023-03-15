package com.rpg.rpgGenerator.controller;

import com.rpg.rpgGenerator.entity.Abilita;
import com.rpg.rpgGenerator.service.AbilitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/abilita")
public class AbilitaController {

    @Autowired
    private AbilitaService abilitaService;

    /*
    @GetMapping("")
    public List<Abilita> findAll() {
        return abilitaService.findAll();
    }
     */

    @GetMapping("/{nomeAbilita}") //READ GET BY ID
    public ResponseEntity<Abilita> getAbilitaByNomeAbilita(@PathVariable String nomeAbilita){
        Optional<Abilita> existingAbilita = Optional.ofNullable(abilitaService.findByNomeAbilita(nomeAbilita));
        try {
            if(existingAbilita.isPresent()){
                return new ResponseEntity<>(existingAbilita.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /* METODO GET READ
    @GetMapping("/{id}")
    public ResponseEntity<Abilita> findById(@PathVariable String id) {
        Optional<Abilita> abilita = abilitaService.findById(id);
        return abilita.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/cerca-per-nome-abilita/{nomeAbilita}")
    public ResponseEntity<Abilita> findByNomeAbilita(@PathVariable String nomeAbilita) {
        Abilita abilita = abilitaService.findByNomeAbilita(nomeAbilita);
        return abilita != null ? ResponseEntity.ok(abilita) : ResponseEntity.notFound().build();
    }

    @GetMapping("/cerca-per-nome-attributi-abilita/{nomeAttributiAbilita}")
    public List<Abilita> findAllByNomeAttributiAbilitaContaining(@PathVariable String nomeAttributiAbilita) {
        return abilitaService.findAllByNomeAttributiAbilitaContaining(nomeAttributiAbilita);
    }
    */

    @PostMapping("")
    public Abilita create(@RequestBody Abilita abilita) {
        return abilitaService.insertAbilita(abilita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abilita> update(@PathVariable String id, @RequestBody Abilita abilita) {
        Optional<Abilita> existingAbilita = Optional.ofNullable(abilitaService.findByNomeAbilita(id));
        if (existingAbilita.isPresent()) {
            Abilita updatedAbilita = abilitaService.save(abilita);
            return ResponseEntity.ok(updatedAbilita);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        Optional<Abilita> abilita = Optional.ofNullable(abilitaService.findByNomeAbilita(id));
        if (abilita.isPresent()) {
            abilitaService.delete(abilita.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}