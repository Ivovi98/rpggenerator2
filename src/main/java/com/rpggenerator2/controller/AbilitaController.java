package com.rpggenerator2.controller;

import com.rpggenerator2.entity.Abilita;
import com.rpggenerator2.service.AbilitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Optional;

@RestController
@RequestMapping("/abilita")
public class AbilitaController {

    @Autowired
    private AbilitaService abilitaService;

    /*@GetMapping("/{id}") //READ GET BY ID
    public ResponseEntity<Abilita> getAbilitaById(@PathVariable Long id){
        Optional<Abilita> existingAbilita = Optional.ofNullable(abilitaService.findByIdAbilita(id));
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
    }*/
    @GetMapping("/{id}")
    public ResponseEntity<Abilita> findById(@PathVariable Long id) {
        Optional<Abilita> abilita = abilitaService.findById(id);
        if (abilita.isPresent()) {
            return ResponseEntity.ok(abilita.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Abilita> create(@RequestBody Abilita abilita) {
        try {
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            abilita.setDataCreazione(timestamp);
            Abilita a = abilitaService.save(abilita); //APPOGGINO
            if(a == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(a, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Abilita> updateAbilita(@PathVariable Long id, @RequestBody Abilita abilita) {
        Optional<Abilita> existingAbilita = abilitaService.findById(id);

        if (!existingAbilita.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404
        } else {
            Abilita abilitaDiAppoggio = existingAbilita.get();
            abilitaDiAppoggio.setNomeAttributiAbilita(abilita.getNomeAttributiAbilita());
            abilitaDiAppoggio.setNomeAbilita(abilita.getNomeAbilita());
            abilitaDiAppoggio.setClasse(abilita.getClasse());
            abilitaDiAppoggio.setVersione(abilita.getVersione());
            abilitaDiAppoggio.setDataUltimaModifica(abilita.getDataUltimaModifica());
            Abilita abilitaAggiornata = abilitaService.save(abilitaDiAppoggio);
            return new ResponseEntity<>(abilitaAggiornata, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<Abilita> abilita = (abilitaService.findById(id));
        if (abilita.isPresent()) {
            abilitaService.delete(abilita.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
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

    @GetMapping("")
    public List<Abilita> findAll() {
        return abilitaService.findAll();
    }
    */
}