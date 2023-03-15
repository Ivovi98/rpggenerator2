package com.rpggenerator2.controller;

import com.rpg.rpgGenerator.entity.Personaggio;
import com.rpg.rpgGenerator.service.PersonaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Optional;
public class PersonaggioController {

    @Autowired
    private PersonaggioService personaggioService;

    @GetMapping("/{id}") //READ GET BY ID
    public ResponseEntity<Personaggio> getPersonaggioById(@PathVariable Long id){
        Optional<Personaggio> existingPersonaggio = personaggioService.findById(id);
        try {
            if(existingPersonaggio.isPresent()){
                return new ResponseEntity<>(existingPersonaggio.get(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping //CREATE
    public ResponseEntity<Personaggio> insertPersonaggioPersonaggio(@RequestBody Personaggio personaggio){
        try {
            Personaggio p = personaggioService.insertPersonaggio(personaggio);
            if(p == null){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(p, HttpStatus.CREATED); //201
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/{id}/{nome}") //EDIT
    public ResponseEntity<Personaggio> updatePersonaggio(@PathVariable Long id,
                                                       @PathVariable String nomePersonaggio){
        Optional<Personaggio> existingPersonaggio = personaggioService.findById(id);
        try {
            if(existingPersonaggio.isPresent()){
                Personaggio personaggio = existingPersonaggio.get();
                personaggio.setNomePersonaggio(nomePersonaggio);
                personaggio.setDataUltimaModifica(new Timestamp(System.currentTimeMillis()));
                personaggio.setVersione(personaggio.getVersione() + 1);
                Personaggio updatedPersonaggio = personaggioService.save(personaggio);
                return new ResponseEntity<>(updatedPersonaggio, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}") //DELETE
    public ResponseEntity<Void> deletePersonaggio(@PathVariable Long id){
        Optional<Personaggio> existingPersonaggio = personaggioService.findById(id);
        try {
            if(existingPersonaggio.isPresent()){
                personaggioService.delete(existingPersonaggio.get());
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
